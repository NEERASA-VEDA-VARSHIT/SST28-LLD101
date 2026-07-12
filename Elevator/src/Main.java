import java.util.List;
import model.Elevator;
import service.ElevatorController;
import strategy.NearestElevatorStrategy;

/**
 * Simulation entry point
 */
public class Main {

    public static void main(String[] args) {

        List<Elevator> elevators = List.of(
                new Elevator(1),
                new Elevator(2));

        ElevatorController controller = new ElevatorController(elevators, new NearestElevatorStrategy());

        controller.requestElevator(5);
        controller.requestElevator(2);
    }
}