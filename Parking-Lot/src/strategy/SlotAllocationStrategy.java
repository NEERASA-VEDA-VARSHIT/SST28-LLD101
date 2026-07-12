package strategy;

import enums.VehicleType;
import java.util.List;
import model.Floor;
import model.ParkingSlot;

/**
 * Strategy interface for slot allocation logic.
 * Allows plugging different allocation algorithms.
 */
public interface SlotAllocationStrategy {

    /**
     * Finds an appropriate slot for a vehicle
     */
    ParkingSlot findSlot(List<Floor> floors, VehicleType type);
}