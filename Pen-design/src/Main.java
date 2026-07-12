// Entry point of the application
// Simulates client interaction with Pen using factory
import pen.*;

public class Main {

    public static void main(String[] args) {
        
        // Creates a Pen using factory based on input parameters
        // Demonstrates usage of start, write, close, and refill operations
        Pen pen = PenFactory.getPen("gel", "blue", true);

        try {
            pen.start();
            pen.write("Hello Scaler");
            pen.close();
            pen.refill();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}