package org.example.module10.serialize;

import java.io.*;

public class Demo {
    public static void main(String[] args) {
        User user = new User("Mykola", "qwerty");
        Task task = new Task(new Command("rm -f user.bin"));


        serialize(user, "user.bin");
//        serialize(task, "virus.bin");


//        User anotherUser = deserializeUser("user.bin");
//        User anotherUser = deserializeUser("virus.bin");
//        System.out.println("anotherUser = " + anotherUser);
    }

    // log4j -> log4shell
    private static void serialize(Object object, String filePath) {
        try (OutputStream outputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(object);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static User deserializeUser(String filePath) {
        User result = null;
        try (InputStream inputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            result = (User) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
