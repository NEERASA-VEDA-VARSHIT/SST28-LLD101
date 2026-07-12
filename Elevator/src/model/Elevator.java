package model;

import enums.Direction;
import enums.ElevatorState;

import java.util.TreeSet;

/**
 * Represents a single elevator
 * NOTE: Keeps logic minimal (SRP)
 */
public class Elevator {

    private int id;
    private int currentFloor;
    private ElevatorState state;

    // Requests (sorted for scheduling)
    private TreeSet<Integer> upRequests;
    private TreeSet<Integer> downRequests;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.state = ElevatorState.IDLE;
        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<>();
    }

    /**
     * Add a request to elevator queue
     */
    public void addRequest(int floor) {
        if (floor > currentFloor) {
            upRequests.add(floor);
        } else {
            downRequests.add(floor);
        }
    }

    /**
     * Moves elevator one step
     */
    public void move() {
        if (state == ElevatorState.MOVING_UP) {
            currentFloor++;
        } else if (state == ElevatorState.MOVING_DOWN) {
            currentFloor--;
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }
}