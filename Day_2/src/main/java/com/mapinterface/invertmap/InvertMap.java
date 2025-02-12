package com.mapinterface.invertmap;

import java.util.*;
import java.util.stream.Collectors;

public class InvertMap {
    public static void main(String[] args) {
        Map<Integer, String> originalMap = new HashMap<>();
        originalMap.put(1, "A");
        originalMap.put(2, "B");
        originalMap.put(3, "B");
        originalMap.put(4, "C");

        // Invert the map
        Map<String, List<Integer>> invertedMap = invertMap(originalMap);

        // Print the inverted map
        invertedMap.forEach((key, value) -> System.out.println(key + " = " + value));
    }

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        return map.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,  // Use value as key
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList()) // Collect keys into a list
                ));
    }
}

