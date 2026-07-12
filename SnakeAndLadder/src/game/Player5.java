// Represents a player in the game
// Tracks player name and current position
package game;

public class Player5 {

    private String name;
    private int position;

    // Initializes player with starting position outside board (0)
    public Player5(String name) {
        this.name = name;
        this.position = 0;
    }

    // Getter and setter for player position
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}