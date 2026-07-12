package service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import model.*;
import strategy.SlotAllocationStrategy;

/**
 * Core service class.
 * Handles parking, exit, and billing operations.
 */
public class ParkingLotService {

    private List<Floor> floors;
    private SlotAllocationStrategy strategy;
    private Map<String, Ticket> activeTickets;

    /**
     * Initialize parking lot with floors and strategy
     */
    public ParkingLotService(List<Floor> floors, SlotAllocationStrategy strategy) {
        this.floors = floors;
        this.strategy = strategy;
        this.activeTickets = new HashMap<>();
    }

    /**
     * Parks a vehicle and generates ticket
     */
    public Ticket parkVehicle(Vehicle vehicle) {

        ParkingSlot slot = strategy.findSlot(floors, vehicle.getType());

        if (slot == null) {
            System.out.println("No slot available");
            return null;
        }

        slot.parkVehicle();

        String ticketId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, vehicle, slot);

        activeTickets.put(ticketId, ticket);

        return ticket;
    }

    /**
     * Handles vehicle exit and bill generation
     */
    public double exitVehicle(String ticketId) {

        Ticket ticket = activeTickets.get(ticketId);

        if (ticket == null) {
            System.out.println("Invalid ticket");
            return 0;
        }

        ticket.getSlot().removeVehicle();

        long hours = Duration.between(
                ticket.getEntryTime(),
                LocalDateTime.now()).toHours();

        activeTickets.remove(ticketId);

        return calculateBill(hours);
    }

    /**
     * Simple billing logic
     */
    private double calculateBill(long hours) {
        return hours * 20; // flat rate per hour
    }
}