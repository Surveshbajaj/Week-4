package com.listinterface.reverselist;

import java.util.ArrayList;
import java.util.LinkedList;

public class ReverseList {

    // Method to reverse an ArrayList in-place
    public static void ArrayList(ArrayList<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;

        // Swap elements from both ends moving towards the center
        while (left < right) {
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            left++;
            right--;
        }
    }

    // Method to reverse a LinkedList and return a new reversed LinkedList
    public static LinkedList<Integer> LinkedList(LinkedList<Integer> arr) {
        LinkedList<Integer> reversedRolls = new LinkedList<>();

        // Iterate backward and add elements to the new LinkedList
        for (int i = arr.size() - 1; i >= 0; i--) {
            reversedRolls.add(arr.get(i));
        }
        return reversedRolls;
    }

    public static void main(String[] args) {
        // Creating an ArrayList and adding elements
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(4);
        nums.add(3);
        nums.add(2);
        nums.add(1);

        // Printing original ArrayList
        System.out.println("Original ArrayList: " + nums);

        // Reversing the ArrayList in place
        ArrayList(nums);

        // Printing reversed ArrayList
        System.out.println("Reversed ArrayList: " + nums);
        System.out.println();

        // Creating a LinkedList and adding elements
        LinkedList<Integer> rolls = new LinkedList<>();
        rolls.add(5);
        rolls.add(4);
        rolls.add(3);
        rolls.add(2);
        rolls.add(1);

        // Printing original LinkedList
        System.out.println("Original LinkedList: " + rolls);

        // Reversing the LinkedList and storing in a new list
        LinkedList<Integer> reversedList = LinkedList(rolls);

        // Printing reversed LinkedList
        System.out.println("Reversed LinkedList: " + reversedList);
    }
}
