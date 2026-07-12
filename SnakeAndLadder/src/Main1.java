
// Entry point of the application
// Simulates client interaction with the game
import game.Difficulty7;
import game.Game2;

// Initializes the game with board size, number of players and difficulty
// Starts the game loop
public class Main1 {
    public static void main(String[] args) {
        Game2 game = new Game2(10, 3, Difficulty7.EASY);
        game.start();
    }
}