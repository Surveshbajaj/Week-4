package com.customexception;

import java.util.Scanner;

public class CustomException {

    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above"); // Throw custom exception
        } else {
            System.out.println("Access granted!"); // Valid age
        }
    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            // Get age input from user
            System.out.println("Enter age:");
            int age = input.nextInt();

            validateAge(age); // Validate age
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage()); // Handle exception
        }
    }
}
