// gives a random no. like 6 dice 
package game;

import java.util.Random;

public class Dice6 {

    private Random rand = new Random();
    
    // no. from 1 to 6
    public int roll() {
        return rand.nextInt(6) + 1;
    }
}