package com.throwvsthrows;

public class ThrowVsThrows {

    // Method that declares an exception using 'throws'
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        try {
            double amount = 1000;  // Valid amount
            double rate = -5;      // Invalid rate (negative)
            int years = 3;

            double interest = calculateInterest(amount, rate, years); // Exception propagates
            System.out.println("Calculated Interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
