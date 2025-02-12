package com.mapinterface.wordfrequencycounter;

import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\sarve\\Desktop\\week 4 pr\\Day_2\\src\\main\\java\\com\\mapinterface\\wordfrequencycounter\\sample.txt";
        Map<String, Integer> wordCountMap = countWordFrequency(filePath);

        // Printing word frequencies
        if (wordCountMap != null) {
            wordCountMap.forEach((word, count) -> System.out.println(word + " = " + count));
        }
    }

    public static Map<String, Integer> countWordFrequency(String filePath) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Convert to lowercase
                line = line.toLowerCase();

                // Remove punctuation manually (only keep alphabets and spaces)
                StringBuilder cleanedLine = new StringBuilder();
                for (char ch : line.toCharArray()) {
                    if (Character.isLetter(ch) || Character.isWhitespace(ch)) {
                        cleanedLine.append(ch);
                    }
                }

                // Split words by whitespace
                String[] words = cleanedLine.toString().split("\\s+");

                // Count word occurrences
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }

        return wordCount;
    }
}
