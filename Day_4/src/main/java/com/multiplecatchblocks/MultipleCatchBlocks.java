package com.multiplecatchblocks;

import java.util.Scanner;

public class MultipleCatchBlocks {

    // Method to print value at a given index
    public static void printValueOfArray(int[] arr, int index) {
        try {
            System.out.println("Value at index " + index + ": " + arr[index]); // Access array element
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!"); // Handle out-of-bounds error
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!"); // Handle null array
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get array length from user
        System.out.println("Enter Length of an array:");
        int n = input.nextInt();

        int[] arr = new int[n]; // Initialize array

        // Populate array with user input
        for (int i = 0; i < n; i++) {
            System.out.println("Enter value at index " + i + ":");
            arr[i] = input.nextInt();
        }

        // Get index input from user
        System.out.println("Enter Index number:");
        int index = input.nextInt();

        // Call method to print value
        printValueOfArray(arr, index);
    }
}
