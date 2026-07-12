package model;

import enums.SlotType;

/**
 * Represents a single parking slot in a floor.
 */
public class ParkingSlot {

    private int slotId;
    private SlotType type;
    private boolean isOccupied;

    /**
     * Initialize slot with id and type
     */
    public ParkingSlot(int slotId, SlotType type) {
        this.slotId = slotId;
        this.type = type;
        this.isOccupied = false;
    }

    /**
     * Checks if slot is free
     */
    public boolean isAvailable() {
        return !isOccupied;
    }

    /**
     * Marks slot as occupied when a vehicle is parked
     */
    public void parkVehicle() {
        this.isOccupied = true;
    }

    /**
     * Frees the slot when vehicle exits
     */
    public void removeVehicle() {
        this.isOccupied = false;
    }

    /**
     * Returns slot type
     */
    public SlotType getType() {
        return type;
    }

    /**
     * Returns slot id
     */
    public int getSlotId() {
        return slotId;
    }
}