package com.annotations.exercise4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface TaskInfo {
    String priority();  // Task priority
    String assignedTo(); // Assigned person
}

// Apply @TaskInfo to a method in TaskManager class
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Sunil")
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}

// Retrieve annotation details using Reflection API
public class CustomAnnotation {
    public static void main(String[] args) throws Exception {
        // Get the method object
        Method method = TaskManager.class.getMethod("completeTask");

        // Check if @TaskInfo is present
        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Task Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }

        // Call the annotated method
        TaskManager taskManager = new TaskManager();
        taskManager.completeTask();
    }
}

