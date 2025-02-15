package com.regex.replaceandmodifystrings;

public class ReplaceMultipleSpaces {


    public static void main(String[] args) {
        String input = "his is an example with multiple     spaces";

        // Replace multiple spaces with a single space
        String result = input.replaceAll("\\s+", " ");

        System.out.println("Original: " + input);
        System.out.println("Processed: " + result);
    }
}

