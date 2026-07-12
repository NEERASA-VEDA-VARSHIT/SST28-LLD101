package strategy;

import enums.SlotType;
import enums.VehicleType;
import java.util.List;
import model.Floor;
import model.ParkingSlot;

/**
 * Simple strategy:
 * Finds the first available slot (acts as nearest).
 * NOTE: Not truly distance-based (tradeoff for simplicity).
 */
public class NearestSlotStrategy implements SlotAllocationStrategy {

    /**
     * Iterates through floors and slots to find available slot
     */
    @Override
    public ParkingSlot findSlot(List<Floor> floors, VehicleType type) {

        SlotType required = mapVehicleToSlot(type);

        for (Floor floor : floors) {
            for (ParkingSlot slot : floor.getSlots()) {
                if (slot.isAvailable() && slot.getType() == required) {
                    return slot;
                }
            }
        }
        return null;
    }

    /**
     * Maps vehicle type to slot type
     */
    private SlotType mapVehicleToSlot(VehicleType type) {
        switch (type) {
            case BIKE:
                return SlotType.SMALL;
            case CAR:
                return SlotType.MEDIUM;
            case TRUCK:
                return SlotType.LARGE;
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}