//Abstract class

// Abstract base class representing a generic Pen
// Defines common properties and behavior shared across all pen types
package pen;

public abstract class Pen {

    protected String color;
    protected boolean isOpen;
    protected boolean hasCap;
    protected int inkLevel;
    protected int capacity;

    // Initializes pen with color, cap presence, and ink capacity
    public Pen(String color, boolean hasCap, int capacity) {
        this.color = color;
        this.hasCap = hasCap;
        this.capacity = capacity;
        this.inkLevel = capacity;
        this.isOpen = false;
    }
 
    // Initializes pen with color, cap presence, and ink capacity
    public void start() {
        if (isOpen) {
            System.out.println("Pen already open");
        } else {
            isOpen = true;
            System.out.println("Pen started");
        }
    }

    // Writes text using available ink
    // Reduces ink level based on text length
    // Throws exception if pen is closed or ink is empty
    public void write(String text) throws PenClosedException, InkEmptyException {
        if (!isOpen) {
            throw new PenClosedException("Pen is closed");
        }

        if (inkLevel <= 0) {
            throw new InkEmptyException("No ink left");
        }

        int required = text.length();

        if (required > inkLevel) {
            text = text.substring(0, inkLevel);
        }

        System.out.println(getType() + " writing: " + text);
        inkLevel -= text.length();
    }


    // so this class followss srp from a perspective of what a pen has to do although it has many small responsibilities in the same niche so it is upto use wether we consider something as a single reponsibility or not and i could imporve the design byseperating the printing functionaly in a seperate class 

    // Closes the pen to prevent further writing
    public void close() {
        isOpen = false;
        System.out.println("Pen closed");
    }

    // Refills the pen ink to maximum capacity
    public void refill() {
        inkLevel = capacity;
        System.out.println("Refilled");
    }

    // Returns the type of pen (implemented by subclasses)
    public abstract String getType();
}