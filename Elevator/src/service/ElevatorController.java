package service;

import model.Elevator;
import strategy.ElevatorSelectionStrategy;

import java.util.List;

/**
 * Central controller for elevator system
 */
public class ElevatorController {

    private List<Elevator> elevators;
    private ElevatorSelectionStrategy strategy;

    public ElevatorController(List<Elevator> elevators,
            ElevatorSelectionStrategy strategy) {
        this.elevators = elevators;
        this.strategy = strategy;
    }

    /**
     * Handles external request (floor button)
     */
    public void requestElevator(int floor) {

        Elevator elevator = strategy.selectElevator(elevators, floor);

        if (elevator == null) {
            System.out.println("No elevator available");
            return;
        }

        elevator.addRequest(floor);

        System.out.println("Elevator " + elevator.getId()
                + " assigned to floor " + floor);
    }
}