package strategy;

import model.Elevator;

import java.util.List;

/**
 * Strategy for selecting best elevator
 */
public interface ElevatorSelectionStrategy {

    Elevator selectElevator(List<Elevator> elevators, int requestFloor);
}