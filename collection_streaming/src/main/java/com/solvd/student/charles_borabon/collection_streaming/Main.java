package com.solvd.student.charles_borabon.collection_streaming;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.solvd.student.charles_borabon.collection_streaming.Employee_Management.Director;
import com.solvd.student.charles_borabon.collection_streaming.Employee_Management.Employee;
import com.solvd.student.charles_borabon.collection_streaming.Employee_Management.Intern;
import com.solvd.student.charles_borabon.collection_streaming.Employee_Management.Manager;

public class Main {

    public static void main(String[] args) {
        // Example data to work with
        List<Employee> employees = Arrays.asList(
            new Director("John", 40, 120000, 0, "", 0.0),
            new Intern("Jane", 22, 30000, 0),
            new Manager("Alice", 35, 90000, 0, "")
        );
        
        // 1. Streaming operations - Non-terminal and terminal
        employees.stream()
            .filter(e -> e.getAge() > 30) // Non-terminal: Filter employees older than 30
            .map(Employee::getName)       // Non-terminal: Map to employee names
            .sorted()                     // Non-terminal: Sort names alphabetically
            .forEach(System.out::println); // Terminal: Print names
        
        // 2. Collecting to List
        List<String> employeeNames = employees.stream()
            .map(Employee::getName)  // Non-terminal: Map to employee names
            .collect(Collectors.toList()); // Terminal: Collect to a List
        
        System.out.println("Employee Names: " + employeeNames);
        
        // 3. Count the number of employees above a certain salary
        long count = employees.stream()
            .filter(e -> e.getSalary() > 50000) // Non-terminal: Filter employees with salary > 50000
            .count(); // Terminal: Count the number of employees
        
        System.out.println("Number of employees with salary > 50000: " + count);

        // Reflection example
        try {
            // Reflection - Get class details
            Class<?> directorClass = Class.forName("com.solvd.student.charles_borabon.collection_streaming.Employee_Management.Director");

            // Display all declared fields
            Field[] fields = directorClass.getDeclaredFields();
            System.out.println("Fields in Director:");
            for (Field field : fields) {
                System.out.println(field.getName() + " - " + field.getType());
            }

            // Display all declared methods
            Method[] methods = directorClass.getDeclaredMethods();
            System.out.println("Methods in Director:");
            for (Method method : methods) {
                System.out.println(method.getName() + " - Return type: " + method.getReturnType());
            }

            // Display constructors
            Constructor<?>[] constructors = directorClass.getDeclaredConstructors();
            System.out.println("Constructors in Director:");
            for (Constructor<?> constructor : constructors) {
                System.out.println(Arrays.toString(constructor.getParameterTypes()));
            }

            // Create an instance using reflection
            Constructor<?> directorConstructor = directorClass.getConstructor(String.class, int.class, double.class, int.class, String.class, double.class);
            Object directorInstance = directorConstructor.newInstance("Mark", 50, 150000, 45, "Sales", 5000.0);

            // Call a method using reflection
            Method setNameMethod = directorClass.getMethod("setName", String.class);
            setNameMethod.invoke(directorInstance, "Mark Updated");

            Method getNameMethod = directorClass.getMethod("getName");
            String updatedName = (String) getNameMethod.invoke(directorInstance);
            System.out.println("Updated Name: " + updatedName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}