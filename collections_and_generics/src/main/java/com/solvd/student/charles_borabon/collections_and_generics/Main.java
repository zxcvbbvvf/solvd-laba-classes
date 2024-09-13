package com.solvd.student.charles_borabon.collections_and_generics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.student.charles_borabon.collections_and_generics.Employee_Management.Director;
import com.solvd.student.charles_borabon.collections_and_generics.Employee_Management.Employee;
import com.solvd.student.charles_borabon.collections_and_generics.Employee_Management.Intern;
import com.solvd.student.charles_borabon.collections_and_generics.Employee_Management.Manager;

public class Main {

    // Custom Exception classes
    public static class InvalidSalaryException extends Exception {
        public InvalidSalaryException(String message) {
            super(message);
        }
    }
    
    public static class InvalidDepartmentException extends Exception {
        public InvalidDepartmentException(String message) {
            super(message);
        }
    }
    
    public static class InvalidEmployeeIDException extends Exception {
        public InvalidEmployeeIDException(String message) {
            super(message);
        }
    }
    
    public static class InvalidWorkHoursException extends Exception {
        public InvalidWorkHoursException(String message) {
            super(message);
        }
    }
    
    public static class ResourceCloseException extends Exception {
        public ResourceCloseException(String message) {
            super(message);
        }
    }

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Employee emp1 = new Manager("Alice", 1001, 50000, "HR");
            Employee emp2 = new Director("Bob", 1002, 80000, "IT", 10000);

            emp1.work(); // Manager work method
            emp2.work(); // Director work method

            // Test final class Intern
            Intern intern = new Intern("Charlie", 1003, 20000);
            intern.work();

            // Test static method and block
            System.out.println("Number of managers: " + Manager.getManagerCount());

            // Test custom exceptions
            validateSalary(-1000);  // Will throw InvalidSalaryException
            validateDepartment("InvalidDept");  // Will throw InvalidDepartmentException

        } catch (InvalidSalaryException | InvalidDepartmentException e) {
            logger.error("Exception caught: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("General exception: " + e.getMessage(), e);
        }

        // Try-with-resources demonstration
        try (Resource resource = new Resource()) {
            resource.useResource();
        } catch (Exception e) {
            logger.error("Exception in resource management: " + e.getMessage(), e);
        }
    }

    // Method to validate salary and throw exception if invalid
    public static void validateSalary(int salary) throws InvalidSalaryException {
        if (salary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative.");
        }
    }

    // Method to validate department
    public static void validateDepartment(String department) throws InvalidDepartmentException {
        if (!department.equals("HR") && !department.equals("IT")) {
            throw new InvalidDepartmentException("Invalid department: " + department);
        }
    }

    // Dummy Resource class to demonstrate try-with-resources
    static class Resource implements AutoCloseable {
        public void useResource() {
            System.out.println("Using resource...");
        }

        @Override
        public void close() throws ResourceCloseException {
            System.out.println("Closing resource...");
            throw new ResourceCloseException("Error while closing resource.");
        }
    }
}