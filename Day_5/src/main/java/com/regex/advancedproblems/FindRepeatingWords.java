package com.regex.advancedproblems;

import java.util.*;
import java.util.regex.*;

public class FindRepeatingWords {

    public static String findRepeatedWords(String input) {
        Set<String> seenWords = new HashSet<>();
        Set<String> repeatedWords = new LinkedHashSet<>(); // To maintain order

        // Convert to lowercase and split by non-word characters
        String[] words = input.toLowerCase().split("\\W+");

        for (String word : words) {
            if (!seenWords.add(word)) { // If already in seenWords, it's repeated
                repeatedWords.add(word);
            }
        }

        return String.join(", ", repeatedWords);
    }

    public static void main(String[] args) {

        String input = "This is is a repeated repeated word test.";

        // Extract repeating words
        String result = findRepeatedWords(input);


        System.out.println("Repeated Words: " + result);
    }
}
