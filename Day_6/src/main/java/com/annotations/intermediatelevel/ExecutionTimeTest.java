package com.annotations.intermediatelevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

// Create a class with methods to be measured
class TaskService {

    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 1_000; i++); // Simulate quick processing
    }

    @LogExecutionTime
    public void slowTask() {
        for (int i = 0; i < 10_000_000; i++); // Simulate heavy computation
    }
}

// Utility to Measure Execution Time Using Reflection
class ExecutionTimeTracker {
    public static void measureExecutionTime(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(obj);
                long endTime = System.nanoTime();
                System.out.println("Execution time of " + method.getName() + " : " + (endTime - startTime) / 1_000_000.0 + " ms");
            }
        }
    }
}

public class ExecutionTimeTest {
    public static void main(String[] args) throws Exception {
        TaskService taskService = new TaskService();
        ExecutionTimeTracker.measureExecutionTime(taskService);
    }
}
