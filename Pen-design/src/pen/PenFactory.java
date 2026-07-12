//pen factory
// Factory class responsible for creating different types of Pen objects
// Encapsulates object creation logic
package pen;

public class PenFactory {

    // Returns appropriate Pen object based on type input
    // Decouples client from concrete implementations
    public static Pen getPen(String type, String color, boolean hasCap) {

        switch (type.toLowerCase()) {
            case "ball":
                return new BallPen(color, hasCap);

            case "gel":
                return new GelPen(color, hasCap);

            case "fountain":
                return new FountainPen(color, hasCap);

            default:
                throw new IllegalArgumentException("Invalid pen type");
        }
    }
}