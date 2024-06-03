package org.example.module10.iostream;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class CustomInputStream extends InputStream {
    private Queue<Byte> bytes = new ArrayDeque<>();

    public CustomInputStream(String input) {
        byte[] inputBytes = input.getBytes();
        for (byte inputByte : inputBytes) {
            bytes.add(inputByte);
        }
    }

    @Override
    public int read() throws IOException {
        if (available() > 0) {
            return bytes.poll();
        }
        return -1;
    }

    @Override
    public int available() throws IOException {
        return bytes.size();
    }
}
