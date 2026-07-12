//exceptions
// Thrown when there is no ink left to write
package pen;

public class InkEmptyException extends Exception {
    public InkEmptyException(String msg) {
        super(msg);
    }
}