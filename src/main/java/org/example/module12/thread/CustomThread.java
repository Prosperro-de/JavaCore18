package org.example.module12.thread;

public class CustomThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from custom thread");
        System.out.println(Thread.currentThread().getName());
    }
}
