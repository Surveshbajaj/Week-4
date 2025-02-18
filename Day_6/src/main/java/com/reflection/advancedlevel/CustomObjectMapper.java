package com.reflection.advancedlevel;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;

 class CustomObjectManager {

    // Method to map Map values to object fields using reflection
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create an instance of the class
            T object = clazz.getDeclaredConstructor().newInstance();

            // Get all fields of the class
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                // Make the field accessible (even if it's private)
                field.setAccessible(true);

                // Check if the field exists in the map and set its value
                if (properties.containsKey(field.getName())) {
                    Object value = properties.get(field.getName());

                    // Set the field's value in the object
                    field.set(object, value);
                }
            }

            return object;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
class Person {
    private String name;
    private int age;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class CustomObjectMapper {
    public static void main(String[] args) {
        // Create a map with field names and values
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Anil");
        properties.put("age", 30);

        // Use the CustomObjectMapper to create an object of type Person
        Person person = CustomObjectManager.toObject(Person.class, properties);

        // Print the mapped object
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}
