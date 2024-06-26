package org.example.module12.waitnotify;

import java.util.LinkedList;
import java.util.Queue;

public class Resource {
    private Queue<Integer> sharedResource = new LinkedList<>();
    private int capacity;

    public Resource(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(Integer item) throws InterruptedException {
        if (sharedResource.size() == capacity) {
            wait();
        }
        sharedResource.add(item);
        System.out.println("Produced: " + item);
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        if (sharedResource.size() == 0) {
            wait();
        }
        Integer item = sharedResource.remove();
        System.out.println("Consumed: " + item);
        notify();
        return item;
    }
}
