package model;

import java.time.LocalDateTime;

/**
 * Represents a parking ticket generated at entry.
 * Contains vehicle, slot and entry time info.
 */
public class Ticket {

    private String ticketId;
    private Vehicle vehicle;
    private ParkingSlot slot;
    private LocalDateTime entryTime;

    /**
     * Constructor to create a ticket
     */
    public Ticket(String ticketId, Vehicle vehicle, ParkingSlot slot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
    }

    /**
     * Returns assigned slot
     */
    public ParkingSlot getSlot() {
        return slot;
    }

    /**
     * Returns entry time
     */
    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    /**
     * Returns ticket id
     */
    public String getTicketId() {
        return ticketId;
    }
}