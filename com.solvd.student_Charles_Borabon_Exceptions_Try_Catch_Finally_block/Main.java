import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The Main class will test try and catch blocks with loggers
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        
        try {
            int[] arr = new int[5];
            arr[6] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Array index is out of bounds");
        }
    }
}
