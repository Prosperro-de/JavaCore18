package org.example.module12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
//        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.lock();
//        reentrantLock.unlock();
//
//        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
//        reentrantReadWriteLock.writeLock();

//        Semaphore
//        CountDownLatch
//        CyclicBarrier

//        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        List<String> emails = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            emails.add("Customer" + i + "@gmail.com");
        }


//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        System.out.println("Send emails");
//        for (String email : emails) {
//            executorService.execute(() -> sendEmails(email));
//        }
//
//        executorService.shutdown();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

        System.out.println("Send emails");

        for (String email : emails) {
//            scheduledExecutorService.schedule(() -> sendEmails(email), 5, TimeUnit.SECONDS);
//            scheduledExecutorService.scheduleWithFixedDelay(
//                    () -> sendEmails(email), 3, 8, TimeUnit.SECONDS);
//            scheduledExecutorService.scheduleAtFixedRate(
//                    () -> sendEmails(email), 5, 5, TimeUnit.SECONDS);
        }
    }

    private static void sendEmails(String email) {
        try {
            Thread.sleep(300L);
            System.out.println("Thread name: " + Thread.currentThread().getName());
            System.out.println("Sending email to: " + email);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
