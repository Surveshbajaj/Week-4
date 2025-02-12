package com.mapinterface.mergetwomaps;

import java.util.*;

public class MergeTwoMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 10);
        map1.put("B", 20);
        map1.put("C", 30);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 15);
        map2.put("C", 25);
        map2.put("D", 40);

        // Merging maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        // Printing merged map
        System.out.println(mergedMap);
    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            result.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return result;
    }
}

