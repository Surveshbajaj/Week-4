package com.reflection.advancedlevel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}

 class LoggingProxyHandler implements InvocationHandler {
    private Object target;

    // Constructor to receive the target object
    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log the method name before invoking
        System.out.println("Method called: " + method.getName());

        // Call the actual method on the real object
        return method.invoke(target, args);
    }
}


public class CustomLoggingProxy {
    public static void main(String[] args) {
        // Create the real object (GreetingImpl)
        Greeting realGreeting = new GreetingImpl();

        // Create the proxy instance with logging functionality
        Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),  // ClassLoader for the interface
                new Class<?>[]{Greeting.class},   // Interfaces to implement
                new LoggingProxyHandler(realGreeting) // InvocationHandler to handle method calls
        );

        // Call methods on the proxy object
        proxyGreeting.sayHello();
    }
}

