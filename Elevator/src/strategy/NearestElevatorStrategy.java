package strategy;

import model.Elevator;

import java.util.List;

/**
 * Selects nearest elevator (simple logic)
 */
public class NearestElevatorStrategy implements ElevatorSelectionStrategy {

    @Override
    public Elevator selectElevator(List<Elevator> elevators, int requestFloor) {

        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            int distance = Math.abs(e.getCurrentFloor() - requestFloor);

            if (distance < minDistance) {
                minDistance = distance;
                best = e;
            }
        }
        return best;
    }
}