package org.example.module11.stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;

public class Demo {
    public static void main(String[] args) {
//        int[] intArray = {1, 23, 43, 24, 554};
//        List<Integer> integerList = List.of(1, 23, 43, 24, 554);

//        Iterator<Integer> iterator = integerList.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        Stream<Integer> stream = integerList.stream();
//        IntStream intStream = Arrays.stream(intArray);
//        IntStream range = IntStream.range(0, 100);
//        Stream<Integer> integerStream = Stream.of(1, 2, 5);
//        Stream<Integer> iterate = Stream.iterate(0, x -> x + 1);
//        Random random = new Random();
//        Stream<Integer> generate = Stream.generate(() -> random.nextInt());
//        Stream<Integer> stream1 = StreamSupport.stream(integerList.spliterator(), false);
//        Stream<Integer> concat = Stream.concat(stream, iterate);

//        int[] intArr = {2, 5, 15, 14};

//        for (int i = 0; i < intArr.length; i++) {
//            intArr[i] = intArr[i] * 2;
//        }
//        System.out.println(Arrays.toString(intArr));
//
//        System.out.println("_______________");
//
//        for (int i : intArr) {
//            i = i * 2;
//        }
//        System.out.println(Arrays.toString(intArr));

        List<Integer> integerList = List.of(2, 5, 15, 14);

        List<Integer> result = new ArrayList<>();
        for (Integer number : integerList) {
            if (number % 2 == 0) {
                int temp = number * 2;
                if (!result.contains(temp)) {
                    result.add(temp);
                }
            }
        }
        System.out.println(result);


        List<Integer> collect = integerList.stream()
                .filter(item -> item % 2 == 0) // Stream<Integer>
                .map(item -> item * 2)// Stream<Integer>
                .filter(item -> item < 20) // Stream<Integer>
                .toList();
        System.out.println(collect);

//        List<Integer> collect = integerList.stream()
//                .filter(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) {
//                        return integer % 2 == 0;
//                    }
//                })
//                .map(new Function<Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer integer) {
//                        return integer * 2;
//                    }
//                })
//                .filter(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) {
//                        return integer < 20;
//                    }
//                })
//                .toList();
    }
}
