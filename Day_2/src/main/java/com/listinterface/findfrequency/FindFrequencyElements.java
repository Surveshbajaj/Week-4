package com.listinterface.findfrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindFrequencyElements {

    // Method to count the frequency of each element in the list
    public static Map<String, Integer> frequencyElements(ArrayList<String> fruit) {
        Map<String, Integer> fruitFreq = new HashMap<>();

        // Iterate through the list and count occurrences of each element
        for (String s : fruit) {
            fruitFreq.put(s, fruitFreq.getOrDefault(s, 0) + 1);
        }

        return fruitFreq;
    }

    public static void main(String[] args) {
        // Creating an ArrayList and adding elements
        ArrayList<String> fruit = new ArrayList<>();
        fruit.add("apple");
        fruit.add("banana");
        fruit.add("apple");
        fruit.add("orange");

        // Calculating the frequency of each fruit
        Map<String, Integer> freq = frequencyElements(fruit);

        // Printing the frequency map
        System.out.println(freq);
    }
}
