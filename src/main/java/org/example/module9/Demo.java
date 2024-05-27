package org.example.module9;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        int [] arrayInt = new int[10];
        arrayInt[0] = 1;
        arrayInt[1] = 2;
        arrayInt[2] = 3;

        CustomContainer<Integer> customContainer = new CustomContainer<>();
        customContainer.add(1);
        customContainer.add(2);
        customContainer.add(3);
//        System.out.println(customContainer.get(0));
//        System.out.println(customContainer.get(1));
//        System.out.println(customContainer.get(2));

//        customContainer.add("My");
//        customContainer.add("first");
//        customContainer.add("custom container");
//        System.out.println(customContainer.get(0));
//        System.out.println(customContainer.get(1));
//        System.out.println(customContainer.get(2));

//        multiply(customContainer.get(0));
//        multiply(customContainer.get(1));
//        multiply(customContainer.get(2));



        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        List<String> anotherList = List.of("hello", "World");

//        System.out.println("list.get(4) = " + list.get(4));
//        print(list);

        LinkedContainer<String> linkedContainer = new LinkedContainer<>();
        linkedContainer.add("Hello");
        linkedContainer.add("From");
        linkedContainer.add("Linked");
        linkedContainer.add("Container");
    }


    //Wildcard
    public static void print(List<?> container) {
        for (Object o : container) {
            System.out.println(o);
        }
    }



}
