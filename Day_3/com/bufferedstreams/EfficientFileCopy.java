package com.bufferedstreams;
import java.io.*;

public class EfficientFileCopy {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\sarve\\Desktop\\week 4 pr\\Day_3\\src\\main\\java\\com\\bufferedstreams\\largefile100mb.txt";
        String bufferedDestFile = "C:\\Users\\sarve\\Desktop\\week 4 pr\\Day_3\\src\\main\\java\\com\\bufferedstreams\\buffered_copy.txt"; // Buffered copy
        String unbufferedDestFile = "C:\\Users\\sarve\\Desktop\\week 4 pr\\Day_3\\src\\main\\java\\com\\bufferedstreams\\unbuffered_copy.txt"; // Unbuffered copy

        // Measure time for Buffered Stream
        long bufferedTime = copyFileWithBufferedStreams(sourceFile, bufferedDestFile);
        System.out.println("Buffered Stream Copy Time: " + bufferedTime + " nanoseconds");

        // Measure time for Unbuffered Stream
        long unbufferedTime = copyFileWithUnbufferedStreams(sourceFile, unbufferedDestFile);
        System.out.println("Unbuffered Stream Copy Time: " + unbufferedTime + " nanoseconds");

        // Compare performance
        System.out.println("\nBuffered stream is " + (unbufferedTime / (double) bufferedTime) + " times faster than unbuffered stream.");
    }

    // Copy file using Buffered Streams (Efficient)
    private static long copyFileWithBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime(); // Start timing

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096]; // Read in 4KB chunks
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error copying file with buffered streams: " + e.getMessage());
        }

        return System.nanoTime() - startTime; // End timing
    }

    // Copy file using Unbuffered Streams (Slow)
    private static long copyFileWithUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime(); // Start timing

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData); // Writing one byte at a time (inefficient)
            }

        } catch (IOException e) {
            System.out.println("Error copying file with unbuffered streams: " + e.getMessage());
        }

        return System.nanoTime() - startTime; // End timing
    }
}
