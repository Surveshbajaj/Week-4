package com.nestedtrycatchblock;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NestedTryCatchBlock {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            // Get array size from user
            System.out.println("Enter array length:");
            int n = input.nextInt();
            int[] arr = new int[n];

            // Populate the array
            for (int i = 0; i < n; i++) {
                System.out.println("Enter value at index " + i + ":");
                arr[i] = input.nextInt();
            }

            // Get index from user
            System.out.println("Enter index:");
            int index = input.nextInt();

            try {
                int element = arr[index]; // Access element at given index
                System.out.println("Value at index " + index + ": " + element);

                // Get divisor from user
                System.out.println("Enter divisor:");
                int divisor = input.nextInt();

                try {
                    int result = element / divisor; // Perform division
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) { // handle ArithmeticException
                    System.out.println("Error: Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) { // handle ArrayIndexOutOfBoundsException
                System.out.println("Error: Invalid array index!");
            }
        } catch (InputMismatchException e) { // handle InputMismatchException
            System.out.println("Error: Enter valid integers.");
        }
    }
}
