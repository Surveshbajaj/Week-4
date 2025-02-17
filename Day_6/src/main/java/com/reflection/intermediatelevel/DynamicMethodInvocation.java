package com.reflection.intermediatelevel;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations{
    public int add(int a, int b){
        return a+b;
    }
    public int subtract(int a, int b){
        return a-b;
    }
    public int multiply(int a, int b){
        return a*b;
    }
}
public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        MathOperations ops = new MathOperations();
        Class<?> cls = MathOperations.class;
        Scanner input = new Scanner(System.in);
        //taking user input
        System.out.println("Enter Method Name: ");
        String methodName = input.next();

        // Access public method based on user input
        Method method = cls.getDeclaredMethod(methodName,int.class,int.class);

        int result = (int) method.invoke(ops,5,20);

        System.out.println(result);

    }
}
