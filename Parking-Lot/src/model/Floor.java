package model;

import java.util.List;

/**
 * Represents a parking floor.
 * Each floor contains multiple parking slots.
 */
public class Floor {

    private int floorNumber;
    private List<ParkingSlot> slots;

    /**
     * Constructor to initialize floor
     */
    public Floor(int floorNumber, List<ParkingSlot> slots) {
        this.floorNumber = floorNumber;
        this.slots = slots;
    }

    /**
     * Returns all slots in this floor
     */
    public List<ParkingSlot> getSlots() {
        return slots;
    }

    /**
     * Returns floor number
     */
    public int getFloorNumber() {
        return floorNumber;
    }
}