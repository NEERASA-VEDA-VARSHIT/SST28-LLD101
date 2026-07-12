//concrete
// Concrete implementation of Pen representing a Fountain Pen
package pen;

public class FountainPen extends Pen {

    public FountainPen(String color, boolean hasCap) {
        super(color, hasCap, 120);
    }

    @Override
    public String getType() {
        return "FountainPen";
    }
}