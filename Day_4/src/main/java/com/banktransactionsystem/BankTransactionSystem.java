package com.banktransactionsystem;

public class BankTransactionSystem {
    public static void withdraw(double amount) throws InsufficientBalanceException {
        double balance = 5000; // Fixed initial balance

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        } else if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        } else {
            System.out.println("Withdrawal successful, new balance: " + (balance - amount));
        }
    }

    public static void main(String[] args) {
        try {
            withdraw(2000); // Valid withdrawal
            withdraw(6000); // Triggers InsufficientBalanceException
            withdraw(-500); // Triggers IllegalArgumentException
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
