package model;

import enums.VehicleType;

/**
 * Represents a vehicle entering the parking lot.
 * Contains basic identifying information.
 */
public class Vehicle {

    private String vehicleNumber;
    private VehicleType type;

    /**
     * Constructor to initialize vehicle details
     */
    public Vehicle(String vehicleNumber, VehicleType type) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
    }

    /**
     * Returns vehicle type
     */
    public VehicleType getType() {
        return type;
    }

    /**
     * Returns vehicle number
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }
}