package com.solvd.student.charles_borabon.exceptoins;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Custom Exceptions
class InvalidEmployeeIdException extends Exception {
    public InvalidEmployeeIdException(String message) {
        super(message);
    }
}

class PromotionNotPossibleException extends Exception {
    public PromotionNotPossibleException(String message) {
        super(message);
    }
}

class RetirementAgeException extends Exception {
    public RetirementAgeException(String message) {
        super(message);
    }
}

class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

class UnauthorizedAccessException extends Exception {
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Application started.");
        
        try {
            handleEmployeeData();
        } catch (InvalidEmployeeIdException | InvalidSalaryException e) {
            logger.error("Critical error while processing employee data: " + e.getMessage(), e);
        }

        // Demonstrate try-with-resources for file reading
        try (FileReader fileReader = new FileReader(new File("employeeData.txt"))) {
            int data = fileReader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fileReader.read();
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error while reading the file: " + e.getMessage());
        }

        logger.info("Application finished.");
    }

    // Method demonstrating two ways of exception handling
    public static void handleEmployeeData() throws InvalidEmployeeIdException, InvalidSalaryException {
        // Example data
        int employeeId = 1234;
        int salary = -5000;
        
        // First way: handle directly with try-catch
        try {
            promoteEmployee(employeeId);
        } catch (PromotionNotPossibleException e) {
            logger.warn("Promotion failed: " + e.getMessage());
        }

        // Second way: throw exception to the caller
        if (salary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative.");
        }

        if (employeeId < 0) {
            throw new InvalidEmployeeIdException("Invalid employee ID.");
        }
    }

    public static void promoteEmployee(int employeeId) throws PromotionNotPossibleException {
        if (employeeId != 1234) {
            throw new PromotionNotPossibleException("Employee is not eligible for promotion.");
        }
        logger.info("Employee " + employeeId + " promoted successfully.");
    }
}
