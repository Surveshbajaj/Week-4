package com.reflection.basiclevel;

import java.lang.reflect.*;
import java.util.Scanner;

public class GetClassInformation {

    // Method to display class information: methods, fields, and constructors
    public static void displayClassInfo(String className) {
        try {
            Class<?> clazz = Class.forName(className);

            // Display the class name
            System.out.println("Class: " + clazz.getName());

            // Display the fields (attributes) of the class
            System.out.println("Fields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(" - " + field.getName() + " : " + field.getType());
            }

            // Display the methods of the class
            System.out.println("Methods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(" - " + method.getName() + " : " + method.getReturnType());
            }

            // Display the constructors of the class
            System.out.println("Constructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(" - " + constructor.getName());
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Get class name input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the class name: ");
        String className = scanner.nextLine();

        // Call displayClassInfo method to display class information
        displayClassInfo(className);
    }
}
