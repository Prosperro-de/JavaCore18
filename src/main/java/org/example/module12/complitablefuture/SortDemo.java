package org.example.module12.complitablefuture;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class SortDemo {
    public static void main(String[] args) {
/*
Time taken : 201354 - bubble 200k
Time taken : 176 - merge 200k
Time taken : 59 - merge 200k async
 */
        Integer[] intArray = new Integer[200_000];
        Random random = new Random();
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(Integer.MAX_VALUE);
        }
        long currentTime = System.currentTimeMillis();

//        bubbleSort(intArray);
        mergeSort(intArray);

        long timeResult = System.currentTimeMillis() - currentTime;

        System.out.println("Time taken : " + timeResult);
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
        if (array.length == 1) {
            return;
        }
        int middleIndex = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, middleIndex);
        T[] right = Arrays.copyOfRange(array, middleIndex, array.length);
        CompletableFuture.runAsync(() -> mergeSort(left));
        CompletableFuture.runAsync(() -> mergeSort(right));

        performMergeSort(array, left, right);
    }

    private static  <T extends Comparable<? super T>> void performMergeSort(T[] intArray, T[] left, T[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int sourceIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
                intArray[sourceIndex] = left[leftIndex];
                leftIndex++;
                sourceIndex++;
            } else {
                intArray[sourceIndex] = right[rightIndex];
                rightIndex++;
                sourceIndex++;
            }
        }
        while (leftIndex < left.length) {
            intArray[sourceIndex] = left[leftIndex];
            leftIndex++;
            sourceIndex++;
        }
        while (rightIndex < right.length) {
            intArray[sourceIndex] = right[rightIndex];
            rightIndex++;
            sourceIndex++;
        }
    }

    static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        boolean isSorted = false;
        T buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i].compareTo(arr[i+1]) > 0){
                    isSorted = false;
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                }
            }
        }
    }
}
