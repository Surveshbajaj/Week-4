package com.bankingsystem;

import java.util.*;

class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>(); // Stores account balance
    private TreeMap<Double, String> sortedAccounts = new TreeMap<>(); // Sorts accounts by balance
    private Queue<String> withdrawalQueue = new LinkedList<>(); // Queue for withdrawal requests

    // Create a new account
    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedAccounts.put(initialBalance, accountNumber);
    }

    // Deposit money into an account
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            sortedAccounts.remove(accounts.get(accountNumber)); // Remove old balance
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
            System.out.println("Deposited $" + amount + " into account " + accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Request a withdrawal (adds to queue)
    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal request added for account " + accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Process the next withdrawal request
    public void processWithdrawal(double amount) {
        if (withdrawalQueue.isEmpty()) {
            System.out.println("No withdrawal requests in queue.");
            return;
        }

        String accountNumber = withdrawalQueue.poll(); // Get the next account in queue
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                sortedAccounts.remove(currentBalance); // Remove old balance
                accounts.put(accountNumber, newBalance);
                sortedAccounts.put(newBalance, accountNumber);
                System.out.println("Withdrew $" + amount + " from account " + accountNumber);
            } else {
                System.out.println("Insufficient balance for account " + accountNumber);
            }
        }
    }

    // Display all accounts sorted by balance
    public void displayAccountsSortedByBalance() {
        System.out.println("\n Accounts Sorted by Balance:");
        for (Map.Entry<Double, String> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getValue() + " | Balance: $" + entry.getKey());
        }
    }

    // Display withdrawal queue
    public void displayWithdrawalQueue() {
        System.out.println("\n Withdrawal Queue: " + withdrawalQueue);
    }
}

public class BankApplication {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Create accounts
        bank.createAccount("A1001", 5000);
        bank.createAccount("A1002", 3000);
        bank.createAccount("A1003", 7000);

        // Deposit money
        bank.deposit("A1001", 2000);
        bank.deposit("A1002", 1000);

        // Request withdrawals
        bank.requestWithdrawal("A1001");
        bank.requestWithdrawal("A1003");

        // Display accounts sorted by balance
        bank.displayAccountsSortedByBalance();

        // Display withdrawal queue
        bank.displayWithdrawalQueue();

        // Process withdrawal
        bank.processWithdrawal(1500);
        bank.processWithdrawal(5000);

        // Display updated accounts
        bank.displayAccountsSortedByBalance();
    }
}

