package com.solvd.student.charles_borabon.exceptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.student.charles_borabon.exceptions.Employee_Management.CustomExceptions;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            handleEmployee();
            handlePromotion();
        } catch (CustomExceptions.InvalidEmployeeException | CustomExceptions.InvalidPromotionException e) {
            logger.error("Exception occurred: " + e.getMessage());
        }

        // Handle exceptions using try-with-resources
        try (AutoCloseableResource resource = new AutoCloseableResource()) {
            handleTransfer();
        } catch (CustomExceptions.TransferNotAllowedException e) {
            logger.error("Exception in transfer: " + e.getMessage());
        } catch (Exception e) {
            logger.error("General exception: " + e.getMessage());
        }

        logger.info("Application finished");
    }

    private static void handleEmployee() throws  CustomExceptions.InvalidEmployeeException {
        logger.info("Handling employee...");
        // Simulate invalid employee handling
        throw new CustomExceptions().new InvalidEmployeeException("Employee ID is not valid.");
    }

    private static void handlePromotion() throws CustomExceptions.InvalidPromotionException {
        logger.info("Handling promotion...");
        // Simulate invalid promotion handling
        throw new CustomExceptions().new InvalidPromotionException("Promotion requirements not met.");
    }

    private static void handleTransfer() throws CustomExceptions.TransferNotAllowedException {
        logger.info("Handling transfer...");
        // Simulate invalid transfer
        throw new CustomExceptions().new TransferNotAllowedException("Employee cannot be transferred.");
    }

    // Simulating a resource that needs to be closed
    static class AutoCloseableResource implements AutoCloseable {
        @Override
        public void close() {
            logger.info("Resource closed");
        }
    }
}