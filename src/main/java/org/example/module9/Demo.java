package org.example.module9;

import java.util.*;

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

//        LinkedContainer<String> linkedContainer = new LinkedContainer<>();
//        linkedContainer.add("Hello");
//        linkedContainer.add("From");
//        linkedContainer.add("Linked");
//        linkedContainer.add("Container");
//
//
//        System.out.println(linkedContainer.get(0));
//        System.out.println(linkedContainer.get(1));
//        System.out.println(linkedContainer.get(2));
//        System.out.println(linkedContainer.get(3));


//        Map<String, Map<String, List<List<Map<String, String>>>>> map = new HashMap<>();
        Map<String, String> demoMap = new HashMap<>();
        demoMap.put("Hello", "World");
        demoMap.put("Hey", "Everyone");
        demoMap.put("Hi", "all");
        demoMap.put(null, "here key is null");

//        System.out.println(demoMap.get("Hello"));
//        System.out.println(demoMap.get("Hey"));
//        System.out.println(demoMap.get("Hi"));
//        System.out.println(demoMap.get(null));

//        for (Map.Entry<String, String> entry: demoMap.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//            System.out.println("________________________");
//        }

//        MapContainer<String, String> mapContainer = new MapContainer<>();
//        mapContainer.put("Hello", "World");
//        mapContainer.put("Hey", "Everyone");
//        mapContainer.put("Hi", "all");
//
//        System.out.println(mapContainer.get("Hello"));
//        System.out.println(mapContainer.get("Hey"));
//        System.out.println(mapContainer.get("Hi"));

        Student student1 = new Student("Mykola", 22);
        Student student2 = new Student("Olena", 25);
        Student student3 = new Student("Stepan", 33);
        Student student4 = new Student("Stas", 86);

        Map<Student, List<Integer>> studentMap = new HashMap<>();
        studentMap.put(student1, List.of(75, 60, 87));
        studentMap.put(student2, List.of(60, 87, 370));
        studentMap.put(student3, List.of(65, 67, 87));
        studentMap.put(student4, List.of(75, 74, 78));

        student2.setName("Natalia");

        System.out.println(studentMap.get(student1));
        System.out.println(studentMap.get(student2));
        System.out.println(studentMap.get(student3));
        System.out.println(studentMap.get(student4));

        List<String> list1 = new ArrayList<>();
        HashSet<String> strings = new HashSet<>(list1);
// PECS
//        Number number = 5;
//        Integer integer = 10;
//        integer = (Integer) number;
//        number = integer;
//        List<Number> numberList = List.of(1, 3, 4);
//        List<Integer> integerList = List.of(1, 3, 4);

    }


    //Wildcard
    public static void print(List<?> container) {
        for (Object o : container) {
            System.out.println(o);
        }
    }



}
