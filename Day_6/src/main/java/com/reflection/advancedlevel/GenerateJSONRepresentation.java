package com.reflection.advancedlevel;
import java.lang.reflect.Field;

class JsonConverter {

    // Method to convert an object to a JSON-like string using reflection
    public static String toJson(Object object) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        // Get all fields of the object (including private fields)
        Field[] fields = object.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);  // Allow access to private fields

            try {
                // Retrieve the value of the field for the current object
                Object value = field.get(object);
                json.append("\"").append(field.getName()).append("\": ");

                // Handle different types of values (String, primitive types, etc.)
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                // Add a comma if it's not the last field
                if (i < fields.length - 1) {
                    json.append(", ");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }

}
class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
public class GenerateJSONRepresentation {
    public static void main(String[] args) {
        // Create a sample object
        Student student = new Student("Mayank", 30);

        // Convert the object to a JSON-like string
        String jsonString = JsonConverter.toJson(student);

        // Print the resulting JSON-like string
        System.out.println(jsonString);
    }
}
