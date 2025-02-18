package com.reflection.advancedlevel;


import java.lang.reflect.Method;

class Task {
    public void process() {
        try {
            Thread.sleep(2000); // Simulating delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Processing complete!");
    }
}

public class MethodExecutionTimer {
    public static void measureTime(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);

        long startTime = System.nanoTime();
        method.invoke(obj);
        long endTime = System.nanoTime();

        System.out.println("Execution time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) throws Exception {
        Task task = new Task();
        measureTime(task, "process");
    }
}
