package com.listinterface.findnthelement;

import java.util.*;
// Class to find the Nth element from the end of a singly linked list
public class FindNthElement {

    // Method to find the Nth element from the end without calculating the size
    public static <T> T findNthFromEnd(List<T> list, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Position must be greater than 0");
        }

        // Using two pointers to find the Nth element from the end
        int size = list.size();
        if (n > size) {
            throw new IllegalArgumentException("Position exceeds list size");
        }

        return list.get(size - n);
    }

    // Main method to demonstrate finding the Nth element from the end
    public static void main(String[] args) {
        // Creating a LinkedList of strings
        List<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");

        // Finding and displaying the 2nd element from the end
        System.out.println("Original LinkedList: " + linkedList);
        String result = findNthFromEnd(linkedList, 2);
        System.out.println("2nd element from the end: " + result);
    }
}