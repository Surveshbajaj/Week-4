package com.reflection.intermediatelevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Define Custom Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Author {
    String name();
}

class Book {
    @Author(name = "Sunil")  // Apply custom annotation to the class
    public void display() {
        System.out.println("This is a book.");
    }
}


public class RetrieveAnnotationsAtRuntime {
    public static void main(String[] args) throws Exception {
        Book book = new Book();
        Class<?> cls = book.getClass();

        // Access method
        Method method = cls.getMethod("display");

        // Check if annotation is present
        if(method.isAnnotationPresent(Author.class)){
            // Retrieve annotation details
            Author author = method.getAnnotation(Author.class);
            System.out.println("Annotation Name: "+ author.name());
        }
    }
}
