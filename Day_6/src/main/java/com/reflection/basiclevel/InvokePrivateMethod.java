package com.reflection.basiclevel;

import java.lang.reflect.Method;

class Calculator{
    private int multiply(int a, int b){
        return a*b;
    }
}
public class InvokePrivateMethod  {
    public static void main(String[] args) throws Exception{
        Calculator calc = new Calculator();
        Class<?> cls = calc.getClass();
        // Access private method
        Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true); // Allow access to private method


        // Invoke method dynamically
        int result = (int) method.invoke(calc, 5, 10);
        System.out.println("Multiplication Result: " + result);


    }
}
