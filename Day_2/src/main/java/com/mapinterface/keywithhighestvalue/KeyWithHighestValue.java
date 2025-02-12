package com.mapinterface.keywithhighestvalue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KeyWithHighestValue {
    public static String findMaxKey(Map<String, Integer> map) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Map is empty");
        }

        // Find the entry with the maximum value
        Map.Entry<String, Integer> maxEntry = Collections.max(map.entrySet(), Map.Entry.comparingByValue());

        return maxEntry.getKey(); // Return the key with the highest value
    }

    public static void main(String[] args) {
        Map<String, Integer> data = new HashMap<>();
        data.put("A", 45);
        data.put("B", 70);
        data.put("C", 60);


        System.out.println("Key with the maximum value: " + findMaxKey(data)); // Output: David
    }
}

