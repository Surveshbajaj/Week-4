package com.reflection.basiclevel;

import java.lang.reflect.Field;
class Person {
    private int age = 20;
}
public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<?> cls = person.getClass();


        // Access private field
        Field field = cls.getDeclaredField("age");
        field.setAccessible(true); // Allow access to private field


        // Get field value
        System.out.println("Old Value: " + field.get(person));


        // Modify field value
        field.set(person, 30);


        // Get modified value
        System.out.println("New Value: " + field.get(person));
    }
}
