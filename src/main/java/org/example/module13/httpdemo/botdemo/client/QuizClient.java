package org.example.module13.httpdemo.botdemo.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.example.module13.httpdemo.botdemo.BotConstants;
import org.example.module13.httpdemo.botdemo.model.QuizResponseApiDto;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.example.module13.httpdemo.botdemo.BotConstants.*;

public class QuizClient {
    private HttpClient httpClient = HttpClient.newHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public List<QuizResponseApiDto> getDefaultQuiz() {
        HttpRequest request = HttpRequest.newBuilder(new URI(QUIZ_API))
                .GET()
                .header(QUIZ_AUTH_HEADER, QUIZ_TOKEN)
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), new TypeReference<List<QuizResponseApiDto>>() {
        });
    }
}
