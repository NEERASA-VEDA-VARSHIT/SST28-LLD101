// Represents the game board
// Responsible for managing snakes and ladders (jumps)
package game;

import java.util.*;

public class Board3 {

    private int size;
    private Map<Integer, Jump4> jumps;

    // Initializes board with given size and difficulty
    // Also places snakes and ladders randomly
    public Board3(int size, Difficulty7 difficulty) {
        this.size = size;
        this.jumps = new HashMap<>();
        initializeJumps(difficulty);
    }

    // Randomly places snakes and ladders on the board
    // Number of jumps depends on board size
    private void initializeJumps(Difficulty7 difficulty) {
        int n = size;

        Random rand = new Random();

        for (int i = 0; i < n; i++) {

            // Snake // Snake: head > tail (moves player down)
            int head = rand.nextInt(size * size - 1) + 2;
            int tail = rand.nextInt(head - 1) + 1;

            jumps.put(head, new Jump4(head, tail));

            // Ladder // Ladder: start < end (moves player up)
            int start = rand.nextInt(size * size - 1) + 1;
            int end = rand.nextInt(size * size - start) + start + 1;

            jumps.put(start, new Jump4(start, end));
        }
    }

    // Checks if a position has a snake or ladder
    // Returns updated position after jump
    public int resolveJump(int position) {
        if (jumps.containsKey(position)) {
            Jump4 jump = jumps.get(position);
            System.out.println("Jump from " + jump.getStart() + " to " + jump.getEnd());
            return jump.getEnd();
        }
        return position;
    }

    public int getSize() {
        return size;
    }
}