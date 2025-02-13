package com.countwordinafile;

import java.io.*;
import java.util.*;

public class CountWordInAFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\sarve\\Desktop\\week 4 pr\\Day_3\\src\\main\\java\\com\\countwordinafile\\textfile.txt"; // Specify file path

        // Count word occurrences
        HashMap<String, Integer> wordCount = countWords(filePath);

        // Display the top 5 most frequent words
        displayTopWords(wordCount, 5);
    }

    // Method to count words from the file
    private static HashMap<String, Integer> countWords(String filePath) {
        HashMap<String, Integer> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Normalize words (convert to lowercase and remove punctuation)
                String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");

                // Count word occurrences
                for (String word : words) {
                    if (!word.isEmpty()) { // Ignore empty words
                        map.put(word, map.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return map;
    }

    // Method to display the top N most frequent words
    private static void displayTopWords(HashMap<String, Integer> wordCount, int topN) {
        // Convert map to a list and sort by word frequency (descending order)
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\nTop " + topN + " most frequent words:");
        for (int i = 0; i < Math.min(topN, sortedList.size()); i++) {
            System.out.println(sortedList.get(i).getKey() + " - " + sortedList.get(i).getValue());
        }
    }
}
