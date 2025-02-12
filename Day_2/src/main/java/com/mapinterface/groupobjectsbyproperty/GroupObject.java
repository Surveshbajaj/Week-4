package com.mapinterface.groupobjectsbyproperty;

import java.util.*;
import java.util.stream.Collectors;

// Employee class with name and department properties
class Employee {
    String name;
    String department;

    // Constructor to initialize employee details
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Overriding toString() for better output representation
    @Override
    public String toString() {
        return name;
    }
}

public class GroupObject {
    public static void main(String[] args) {
        // Creating a list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Anil", "HR"),
                new Employee("Gukesh", "Engineering"),
                new Employee("Yogesh", "HR")
        );

        // Grouping employees by department
        Map<String, List<Employee>> groupedByDepartment = groupByDepartment(employees);

        // Printing the grouped employees
        groupedByDepartment.forEach((dept, empList) ->
                System.out.println(dept + " -> " + empList)
        );
    }

    // Method to group employees by department using Java Streams
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.department));
    }
}
