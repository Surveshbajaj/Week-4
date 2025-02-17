package com.reflection.basiclevel;

class Car {
    private String name;
    public int age;
}
public class GetClassInformation {
    public static void main(String[] args) throws ClassNotFoundException {
        // Method 1: Using .class
        Class<?> cls1 = Car.class;
        System.out.println("Class Name: " + cls1.getName());
    }
}
