package org.example.module12.thread;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

    static final Object monitor = new Object();
//    public static int counter;
    public static AtomicInteger counter = new AtomicInteger();


    public static void main(String[] args) throws InterruptedException {
//        createThreadExample();
//        createMultipleThreads();
//        concurrentAccess();
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("i = " + i);
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();


        Thread.sleep(3000L);
        t.interrupt();

    }

    private static void concurrentAccess() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
//                    increment();
                    counter.getAndAdd(1);
                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(counter);
    }

    private static void increment() {
        synchronized (monitor) {
//            counter++;
        }
    }

    private static void createMultipleThreads() throws InterruptedException {
        Thread firstThread = new Thread(() -> System.out.println("Starting thread 1"));
        firstThread.start();

        Thread secondThread = new Thread(() -> {
            try {
                System.out.println("Starting thread 2");
                Thread.sleep(3000L);
                System.out.println("End thread 2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
//        secondThread.setDaemon(true);
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println("End of the main thread");
    }


    private static void createThreadExample() {
        Thread.currentThread().setName("GoiT");
        String name = Thread.currentThread().getName();
        System.out.println("name = " + name);

        CustomThread customThread = new CustomThread();
        customThread.start();

        Thread runThread = new Thread(new CustomRunnable());
        runThread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class with runnable");
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> {
            System.out.println("Lambda execution");
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
