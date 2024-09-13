package com.solvd.student.charles_borabon.exceptions.Employee_Management;

public class CustomExceptions {
    public class InvalidEmployeeException extends Exception {
        public InvalidEmployeeException(String message) {
            super(message);
        }
    }
    
    public class InvalidPromotionException extends Exception {
        public InvalidPromotionException(String message) {
            super(message);
        }
    }
    
    public class InvalidRetirementException extends Exception {
        public InvalidRetirementException(String message) {
            super(message);
        }
    }
    
    public class TransferNotAllowedException extends Exception {
        public TransferNotAllowedException(String message) {
            super(message);
        }
    }
    
    public class InvalidTrainingException extends Exception {
        public InvalidTrainingException(String message) {
            super(message);
        }
    }
}
