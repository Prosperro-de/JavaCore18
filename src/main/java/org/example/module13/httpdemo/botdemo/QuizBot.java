package org.example.module13.httpdemo.botdemo;

import org.example.module12.waitnotify.Producer;
import org.example.module13.httpdemo.botdemo.client.QuizClient;
import org.example.module13.httpdemo.botdemo.model.QuizResponseApiDto;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static org.example.module13.httpdemo.botdemo.BotConstants.BEGIN;
import static org.example.module13.httpdemo.botdemo.BotConstants.START;

public class QuizBot extends TelegramLongPollingBot {
    private QuizClient quizClient = new QuizClient();
    private Map<String, Quiz> context = new ConcurrentHashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage message = new SendMessage();
        String chatId = update.getMessage().getChatId().toString();
        message.setChatId(chatId);
        System.out.println("update.getChatMember().getFrom().getUserName() = " + update.getChatMember().getFrom().getUserName());
        if (isMessagePresent(update) &&
                update.getMessage().getText().equalsIgnoreCase(START)) {
            List<QuizResponseApiDto> defaultQuiz = quizClient.getDefaultQuiz();
            context.put(chatId, new Quiz(defaultQuiz));
            message.setText(String.format("Quiz is ready and contains %s questions. Press %s to start", defaultQuiz.size(), BEGIN));
            message.setReplyMarkup(setupBeginButton());
        } else if (isMessagePresent(update) &&
                update.getMessage().getText().equalsIgnoreCase(BEGIN)) {
            sendNextMessage(chatId, message);

        } else {
           String currentAnswer = update.getMessage().getText();
            Quiz quiz = context.get(chatId);
            if (currentAnswer.equalsIgnoreCase(quiz.getLastCorrectAnswer())) {
                sendNextMessage(chatId, message);
            } else {
                message.setText("Incorrect answer. Please try again");
            }
        }
        try {
            execute(message); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendNextMessage(String chatId, SendMessage message) {
        Quiz quiz = context.get(chatId);
        List<QuizResponseApiDto> quizList = quiz.getQuizList();
        if (quizList.size() > quiz.getCounter().get()) {
            AtomicInteger counter = quiz.getCounter();
            QuizResponseApiDto quizResponseApiDto = quizList.get(counter.getAndAdd(1));
            message.setText(quizResponseApiDto.getQuestion());
            message.setReplyMarkup(setupQuizKeyboard(quizResponseApiDto));
            String correctAnswerKey = findCorrectAnswerKey(quizResponseApiDto.getCorrectAnswers());
            quiz.setLastCorrectAnswer(quizResponseApiDto.getAnswers().get(correctAnswerKey));

        } else {
            message.setText("Quiz is completed");
            quiz.setLastCorrectAnswer(null);
        }
    }


    @Override
    public String getBotUsername() {
        return BotConstants.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BotConstants.BOT_TOKEN;
    }

    private String findCorrectAnswerKey(Map<String, String> correctAnswers) {
        String answer = correctAnswers.entrySet().stream()
                .filter(entry -> entry.getValue().equals("true"))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
        return answer.replace("_correct", "");
    }

    private ReplyKeyboard setupQuizKeyboard(QuizResponseApiDto quizResponseApiDto) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rows = quizResponseApiDto.getAnswers().entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .map(entry -> {
                    KeyboardRow row = new KeyboardRow();
                    row.add(entry.getValue());
                    return row;
                })
                .toList();
        keyboardMarkup.setKeyboard(rows);
        return keyboardMarkup;
    }

    private ReplyKeyboard setupBeginButton() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        KeyboardRow row = new KeyboardRow();
        row.add(BEGIN);
        keyboardMarkup.setKeyboard(List.of(row));
        return keyboardMarkup;
    }

    private static boolean isMessagePresent(Update update) {
        return update.hasMessage() && update.getMessage().hasText();
    }
}
