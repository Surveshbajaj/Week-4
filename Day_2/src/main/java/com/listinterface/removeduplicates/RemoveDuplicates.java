package com.listinterface.removeduplicates;

import java.util.*;

public class RemoveDuplicates {

    // Method to remove duplicates from a list while preserving order
    public static List removeDuplicates(List list) {
        return new ArrayList(new LinkedHashSet(list)); // LinkedHashSet removes duplicates and maintains order
    }

    public static void main(String[] args) {
        // Creating an ArrayList with duplicate elements
        ArrayList nums = new ArrayList();
        nums.add(3);
        nums.add(1);
        nums.add(2);
        nums.add(2);
        nums.add(3);
        nums.add(4);

        // Removing duplicates and storing the unique list
        List uniqueNums = removeDuplicates(nums);

        // Printing the unique list
        System.out.println("Unique List: " + uniqueNums);
    }
}
