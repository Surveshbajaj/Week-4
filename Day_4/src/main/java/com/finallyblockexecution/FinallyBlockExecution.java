package com.finallyblockexecution;

import java.util.Scanner;

public class FinallyBlockExecution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            // Taking user input
            System.out.println("Enter Number 1:");
            int number1 = input.nextInt();

            System.out.println("Enter Number 2:");
            int number2 = input.nextInt();

            // Performing division
            int ans = number1 / number2;
            System.out.println("Answer: " + ans);
        } catch (ArithmeticException e) { // handle ArithmeticException
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            // Finally block always executes
            System.out.println("Operation completed.");
            input.close();
        }
    }
}
