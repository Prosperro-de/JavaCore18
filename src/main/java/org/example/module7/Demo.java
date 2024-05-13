package org.example.module7;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Demo {
    public static void main(String[] args) {
        String firstNameExample = "Mykola";
//        String name2 = "Mykola";
//        String name2 = new String("Mykola");
//        System.out.println(name1 == name2);
//        System.out.println(firstNameExample.equals(name2));
        byte[] bytes = firstNameExample.getBytes();
        System.out.println(Arrays.toString(bytes));
        bytes[2] = 111;
        String parsedName = new String(bytes);
        System.out.println("parsedName = " + parsedName);
        //ASCII
        String hello = "Привіт";
        byte[] helloByteArray = hello.getBytes();
        System.out.println(Arrays.toString(helloByteArray));

        String helloConcatExample = "Hello" + " " + "world" + " " + "from" + " " + "java";
        System.out.println("helloConcatExample = " + helloConcatExample);
        /*
            "Hello"
            "Hello "
            "Hello  world"
            "Hello  world "
            "Hello  world  from"
            "Hello  world  from "
            "Hello  world  from Java"
            "word"
            "from"
            "Java"
            " "
         */
        StringBuilder sb = new StringBuilder();
        String concatenatedResult = sb
                .append("Hello")
                .append(" ")
                .append("world")
                .append(" ")
                .append("from")
                .append(" ")
                .append("java")
                .reverse()
                .toString();
//        sb.reverse().
        System.out.println("concatenatedResult = " + concatenatedResult);

        /*
            "Hello world from java"
         */
    }
}
