package com.uncheckedexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            // Get user input
            System.out.println("Enter Number 1: ");
            int number1 = input.nextInt();

            System.out.println("Enter Number 2: ");
            int number2 = input.nextInt();

            // Perform division
            int ans =  number1 / number2;
            System.out.println("Answer is: " + ans);
        }
        catch (ArithmeticException e) { //handle ArithmeticException
            System.out.println("ArithmeticException: Cannot divide by zero.");
        }
        catch (InputMismatchException e) { //handle InputMismatchException
            System.out.println("InputMismatchException: Please enter a valid integer.");
        }
    }
}
