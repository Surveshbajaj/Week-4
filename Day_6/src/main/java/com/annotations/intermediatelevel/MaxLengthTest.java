package com.annotations.intermediatelevel;

import java.lang.annotation.*;
import java.lang.reflect.Field;

// Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// Apply the annotation to a field in the User class
class User {

    @MaxLength(10) // Restrict username length to a maximum of 10 characters
    private String username;

    public User(String username) throws IllegalArgumentException {
        validateMaxLength(this, username); // Validate username length
        this.username = username;
    }

    // Validate field length using Reflection
    private void validateMaxLength(Object obj, String value) {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                int maxLength = annotation.value();

                if (value.length() > maxLength) {
                    throw new IllegalArgumentException(field.getName() + " exceeds max length of " + maxLength);
                }
            }
        }
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthTest {
    public static void main(String[] args) {
        try {
            User user1 = new User("Pradeep");
            System.out.println("User created: " + user1.getUsername());

            User user2 = new User("ShivrajSolanki");
            System.out.println("User created: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

