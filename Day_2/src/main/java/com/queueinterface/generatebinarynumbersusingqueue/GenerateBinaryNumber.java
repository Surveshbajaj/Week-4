package com.queueinterface.generatebinarynumbersusingqueue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumber {
    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();

        // Start with "1" as the first binary number
        queue.add("1");

        // Generate the first N binary numbers
        for (int i = 0; i < N; i++) {
            // Remove the front element
            String binary = queue.remove();
            System.out.println(binary); // Print the binary number

            // Enqueue the next two binary numbers
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
    }

    public static void main(String[] args) {
        int N = 5; // Change N to generate more numbers
        generateBinaryNumbers(N);
    }
}
