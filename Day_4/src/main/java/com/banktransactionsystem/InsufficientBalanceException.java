package com.banktransactionsystem;

// Custom Checked Exception for insufficient balance
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
