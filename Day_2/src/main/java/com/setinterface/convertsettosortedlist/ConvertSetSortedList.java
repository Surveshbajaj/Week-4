package com.setinterface.convertsettosortedlist;

import java.util.*;

public class ConvertSetSortedList {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        // Convert to list
        List<Integer> sortedList = new ArrayList<>(hashSet);

        // Sort the list in ascending order
        Collections.sort(sortedList);

        System.out.println("Sorted List: " + sortedList);
    }
}

