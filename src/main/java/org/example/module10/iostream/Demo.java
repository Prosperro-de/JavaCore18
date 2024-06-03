package org.example.module10.iostream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        CustomInputStream customInputStream = new CustomInputStream("Hello from the first input stream");
//        while (customInputStream.available() > 0) {
//            char read = (char) customInputStream.read();
//            System.out.print(read);
//        }
//        Scanner scanner = new Scanner(customInputStream, StandardCharsets.UTF_8);
//        Scanner scanner = new Scanner(System.in);
//        String nextLine = scanner.nextLine();
//        System.out.println("nextLine = " + nextLine);
//        BufferedReader br = new BufferedReader(new InputStreamReader(customInputStream));
//        String bufferedLine = br.readLine();
//        System.out.println("bufferedLine = " + bufferedLine);

//        BufferedInputStream bIs = new BufferedInputStream(customInputStream);
//        byte[] bytes = bIs.readAllBytes();
        File file = new File("files/demo.txt");
        if (file.exists()) {
            //try-with-resources
            try (FileInputStream fIs = new FileInputStream(file);
                 Scanner fileScanner = new Scanner(fIs)) {
                while (fileScanner.hasNext()) {
                    System.out.println(fileScanner.nextLine());
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        //_____________________________________
        //        FileWriter fileWriter = new FileWriter(fOs);
//        try (FileOutputStream fOs = new FileOutputStream("outputDemo.txt", true);
//             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fOs))) {
//            String message = "My third message \n";
//            bufferedWriter.write(message);
//        }

        FileOutputStream fOs = new FileOutputStream("outputDemo.bin");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fOs));
        String message = "New message";
        bufferedWriter.write(message);
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}
