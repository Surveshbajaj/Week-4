package com.annotations.exercise5;

import java.lang.annotation.*;
import java.lang.reflect.Method;

//Define the @BugReport annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport{
    String description();
}
//Define a container annotation to hold multiple @BugReport
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}
// Apply the annotation multiple times on a method
class SoftwareModule {
    @BugReport(description = "Null pointer exception on edge cases")
    @BugReport(description = "Memory leak when processing large data")
    public void buggyMethod() {
        System.out.println("This method has known bugs.");
    }
}

//Retrieve and print all bug reports using Reflection
public class RepeatableAnnotation {
    public static void main(String[] args) throws Exception {
        Method method = SoftwareModule.class.getMethod("buggyMethod");

        // Check if method has @BugReport or @BugReports annotation
        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug Description: " + bug.description());
            }
        }
    }
}
