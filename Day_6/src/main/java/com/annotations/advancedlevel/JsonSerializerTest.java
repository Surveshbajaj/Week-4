package com.annotations.advancedlevel;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

//Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// Define the User class with annotated fields
class User2 {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User2(String username, int age) {
        this.username = username;
        this.age = age;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}

// Method to convert object to JSON string using reflection
class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Map<String, Object> jsonMap = new HashMap<>();

        for (Field field : clazz.getDeclaredFields()) {
            // Check if the field has the @JsonField annotation
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                field.setAccessible(true); // Make private fields accessible
                jsonMap.put(annotation.name(), field.get(obj)); // Map field value to JSON key
            }
        }

        // Convert map to JSON string (simple format)
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
        }

        // Remove trailing comma and space
        if (!jsonMap.isEmpty()) {
            json.delete(json.length() - 2, json.length());
        }

        json.append("}");
        return json.toString();
    }
}

public class JsonSerializerTest {
    public static void main(String[] args) throws IllegalAccessException {
        User2 user = new User2("Aman", 30);
        String json = JsonSerializer.toJson(user); // Convert User object to JSON
        System.out.println(json); // Print the JSON string
    }
}
