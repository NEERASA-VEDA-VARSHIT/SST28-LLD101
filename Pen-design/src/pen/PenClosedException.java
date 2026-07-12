//exceptions
// Thrown when write operation is attempted on a closed pen
package pen;

public class PenClosedException extends Exception {
    public PenClosedException(String msg) {
        super(msg);
    }
}