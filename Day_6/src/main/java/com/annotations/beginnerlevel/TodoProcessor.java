package com.annotations.beginnerlevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

//  Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

//Apply the annotation to multiple methods
class ProjectTasks {

    @Todo(task = "Implement user authentication", assignedTo = "Anil", priority = "HIGH")
    public void authenticateUser() {
        System.out.println("Authentication logic to be implemented...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Karan")
    public void optimizeDatabase() {
        System.out.println("Database optimization in progress...");
    }

    @Todo(task = "Improve UI responsiveness", assignedTo = "Rohit", priority = "LOW")
    public void improveUI() {
        System.out.println("UI improvements needed...");
    }
}

// Step 3: Retrieve and print all pending tasks using Reflection
public class TodoProcessor {
    public static void main(String[] args) {
        Class<ProjectTasks> clazz = ProjectTasks.class;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("  Task: " + annotation.task());
                System.out.println("  Assigned To: " + annotation.assignedTo());
                System.out.println("  Priority: " + annotation.priority());
                System.out.println("----------------------------------");
            }
        }
    }
}

