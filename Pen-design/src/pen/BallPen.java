// concrete class

// Concrete implementation of Pen representing a Ball Pen
// Defines specific characteristics like ink capacity
package pen;

public class BallPen extends Pen {

    public BallPen(String color, boolean hasCap) {
        super(color, hasCap, 100);
    }

    @Override
    public String getType() {
        return "BallPen";
    }
}