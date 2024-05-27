package org.example.module9.genericsort;

public class SortUtil {


    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        boolean isSorted = false;
        T buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    isSorted = false;

                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
            }
        }
    }
}
