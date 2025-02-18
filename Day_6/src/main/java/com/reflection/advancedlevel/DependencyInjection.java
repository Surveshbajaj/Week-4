package com.reflection.advancedlevel;

import java.lang.annotation.*;
import java.lang.reflect.*;

// Define @Inject annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

//  Define dependencies
class Service {
    public void perform() {
        System.out.println("Service is running...");
    }
}

//  Define class with dependencies
class Client {
    @Inject
    private Service service;

    public void execute() {
        service.perform();
    }
}

//Implement Dependency Injection container
class DIContainer {
    public static void injectDependencies(Object obj) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = field.getType().getDeclaredConstructor().newInstance();
                field.set(obj, dependency);
            }
        }
    }
}

public class DependencyInjection {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        DIContainer.injectDependencies(client);
        client.execute();
    }
}


