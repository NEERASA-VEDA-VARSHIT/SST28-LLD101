// Orchestrator class - controls overall game flow
// Manages turns, players, and winning condition
package game;

import java.util.*;

public class Game2 {

    private Board3 board;
    private Queue<Player5> players;
    private Dice6 dice;
    private int totalPlayers;

    // Initializes board, dice and player queue
    // Players are added in a queue to simulate turn-based gameplay

    public Game2(int size, int numPlayers, Difficulty7 difficulty) {
        this.board = new Board3(size, difficulty);
        this.dice = new Dice6();
        this.players = new LinkedList<>();
        this.totalPlayers = numPlayers;

        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player5("P" + i));
        }
    }

    // Main game loop
    // Runs until only one player remains (others have won)
    public void start() {
        List<Player5> winners = new ArrayList<>();

        while (players.size() > 1) {

            // Fetch current player (FIFO order for turns)
            Player5 current = players.poll();
            int roll = dice.roll();

            System.out.println(current.getName() + " rolled: " + roll);

            // Calculate next position based on dice roll
            int nextPos = current.getPosition() + roll;

            // Ensure player does not exceed board limit
            if (nextPos <= board.getSize() * board.getSize()) {
                nextPos = board.resolveJump(nextPos);
                current.setPosition(nextPos);
            }

            System.out.println(current.getName() + " at position: " + current.getPosition());

            //// Check if player reached final cell
            if (current.getPosition() == board.getSize() * board.getSize()) {
                System.out.println(current.getName() + " WON!");
                winners.add(current);
            } else {
                players.add(current);// Add player back to queue if game not finished for them
            }
        }

        System.out.println("Game Over");
    }
}