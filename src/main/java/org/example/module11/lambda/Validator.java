package org.example.module11.lambda;


@FunctionalInterface
public interface Validator<T> {
    boolean test(T input);
}
