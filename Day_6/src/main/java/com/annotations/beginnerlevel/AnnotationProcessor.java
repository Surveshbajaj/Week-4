package com.annotations.beginnerlevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the @ImportantMethod annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

// Apply the annotation to at least two methods
class TaskManager {

    @ImportantMethod
    public void processTask() {
        System.out.println("Processing task...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void logTask() {
        System.out.println("Logging task...");
    }

    @ImportantMethod(level = "LOW")
    public void normalTask() {
        System.out.println("This is a normal task.");
    }
}

//  Retrieve and print annotated methods using Reflection
public class AnnotationProcessor {
    public static void main(String[] args) {
        Class<TaskManager> clazz = TaskManager.class;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + " | Importance Level: " + annotation.level());
            }
        }
    }
}

