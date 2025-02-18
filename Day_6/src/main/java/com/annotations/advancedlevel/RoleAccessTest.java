package com.annotations.advancedlevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

// Simulate a User with a role
class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Apply @RoleAllowed to a method
class SecureService {

    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed!");
    }
}

// Method to check role before execution
class RoleChecker {
    public static void executeIfAuthorized(Object obj, String methodName, User user) throws Exception {
        Method method = obj.getClass().getMethod(methodName);

        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
            if (!annotation.value().equals(user.getRole())) {
                System.out.println("Access Denied!");
                return;
            }
        }
        method.invoke(obj);
    }
}

// Test with different users
public class RoleAccessTest {
    public static void main(String[] args) throws Exception {
        SecureService service = new SecureService();

        User adminUser = new User("ADMIN");
        User guestUser = new User("GUEST");

        System.out.println("Trying with ADMIN:");
        RoleChecker.executeIfAuthorized(service, "adminTask", adminUser);

        System.out.println("\nTrying with GUEST:");
        RoleChecker.executeIfAuthorized(service, "adminTask", guestUser);
    }
}

