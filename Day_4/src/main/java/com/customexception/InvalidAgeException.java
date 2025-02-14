package com.customexception;

// Custom Exception for Invalid Age
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
