package org.example.module11.lambda;

import java.util.function.*;

public class Demo {
    public static void main(String[] args) {
//        Validator<String> emailValidator = new Validator<String>() {
//            @Override
//            public boolean test(String input) {
//                return input.matches("[a-z0-9]+@[a-z]{1,10}\\.[a-z]{2,6}");
//            }
//        };

        Validator<String> emailValidator = input -> input.matches("[a-z0-9]+@[a-z]{1,10}\\.[a-z]{2,6}");
        System.out.println(emailValidator.test("mail@gmail.com"));

        Customer customer = new Customer("Mykola", 15);

        Validator<Customer> customerValidator = customerInput -> customerInput.getAge() >= 18;
        System.out.println(customerValidator.test(customer));

        System.out.println(validate("mail@gmail.com", emailValidator));
        System.out.println(validate(customer, customerValidator));

        /*
        Predicate<T>
        Function<T, R>
        Consumer<T>
        Supplier<T>
         */
        Function<String, Integer> mapToInt = Integer::parseInt;
        Integer apply = mapToInt.apply("10");
        System.out.println("apply = " + apply);
        Function<Integer, Integer> multiply = x -> x * 2;
        System.out.println(multiply.apply(10));
        Function<Integer, Integer> multiplyRef = Demo::multiply;
//        Function<Integer, Integer> multiplyRef = x -> multiply(x);

        Function<Integer, Integer> multiplyBlock = x -> {
            System.out.println("Input: " + x);
            return x * 2;
        };
        System.out.println(multiplyBlock.apply(20));

        Consumer<String> consumer = System.out::println;
        Supplier<String> stringSupplier = () -> "Hello from Supplier";

        consumer.accept("hello");
        System.out.println("stringSupplier.get() = " + stringSupplier.get());

        BiFunction<String, String, String> biFunction = (one, two) -> one + two;
        System.out.println(biFunction.apply("Hello ", "BiFunction"));

        Function<String, String> stringFunction = String::toUpperCase;
        String hello = stringFunction.apply("hello");
        System.out.println("hello = " + hello);
    }

    public static <T> boolean validate(T input, Validator<T> validator) {
        return validator.test(input);
    }

    public static int multiply(int x) {
        return x * 2;
    }
}
