package com.reflection.basiclevel;

import java.lang.reflect.Constructor;

class Student{
    String name;
    int rollNo;

     public Student(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "name " + name + " " + "rollNo " + rollNo;
    }
}

public class DynamicallyCreateObjects {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Student.class;
        // Get constructor
        Constructor<?> constructor = cls.getConstructor(String.class,int.class);
        // Create instance dynamically
        Student student = (Student) constructor.newInstance("Adarsh",3);


        String result = student.toString();

        System.out.println(result);

    }
}
