import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileWriter;

// The Main class will test try and catch blocks with loggers
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Log log = new Main.Log();
        String line;

        // Test try and catch blocks
        try {
            int[] arr = new int[5];
            arr[6] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            line = "Array index is out of bounds";
            logger.error(line);
            log.addLine(line);
            log.saveLog();
        }

        try {
            int a = 10/0;
        } catch (ArithmeticException e) {
            line = "Cannot divide by zero"; 
            logger.error(line);
            log.addLine(line);
            log.saveLog();
        }

        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            line = "String is null";
            logger.error(line);
            log.addLine(line);
            log.saveLog();
        }

        try {
            int[] arr = new int[-5];
        } catch (NegativeArraySizeException e) {
            line = "Array size is negative";
            logger.error(line);
            log.addLine(line);
            log.saveLog();
        }

    }

    // Log class to store log messages
    public static class Log {
        private String[] line;
        private static final int MAX_LINES = 100;
        private int currentLine;

        public Log() {
            this.line = new String[MAX_LINES];
            this.currentLine = 0;
        }

        // Add a line to the log
        public void addLine(String line) {
            if (currentLine < MAX_LINES) {
                this.line[currentLine] = line;
                currentLine++;
            } else {
                System.out.println("Log is full");
            }
        }

        // Print the log
        public void printLog() {
            for (int i = 0; i < currentLine; i++) {
                System.out.println(line[i]);
            }
        }

        // Clear the log
        public void clearLog() {
            this.line = new String[MAX_LINES];
            this.currentLine = 0;
        }

        // Save the log to a file
        public void saveLog() {
            // Save log to a file using FileWriter
            try (FileWriter writer = new FileWriter("log.txt")) {
                for (int i = 0; i < currentLine; i++) {
                    writer.write(line[i] + "\n");
                }
                writer.close();
            } catch (Exception e) {
                System.out.println("Error writing to file");
            } finally {
                System.out.println("Log saved");
            }
        }
    }
}
