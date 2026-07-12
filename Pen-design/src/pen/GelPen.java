//concrete 
// Concrete implementation of Pen representing a Gel Pen
package pen;

public class GelPen extends Pen {

    public GelPen(String color, boolean hasCap) {
        super(color, hasCap, 80);
    }

    @Override
    public String getType() {
        return "GelPen";
    }
}