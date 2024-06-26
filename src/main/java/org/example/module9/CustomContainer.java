package org.example.module9;

import java.util.Arrays;

public class CustomContainer<T> {
    private T[] data = (T[]) new Object[10];
    private int size;

    public void add(T element) {
        if (size >= data.length ) {
            //check for array capacity  and resize if full
        }
        data[size] = element;
        size++;
    }

    public T get(int index) {
        //check if index valid throw IndexOutOfBoundsException
        return data[index];
    }

    public int getSize() {
        return size;
    }
}
