import enums.SlotType;
import enums.VehicleType;
import model.*;
import service.ParkingLotService;
import strategy.NearestSlotStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point to simulate parking lot
 */
public class Main {
    public static void main(String[] args) {

        List<ParkingSlot> slots = new ArrayList<>();
        slots.add(new ParkingSlot(1, SlotType.SMALL));
        slots.add(new ParkingSlot(2, SlotType.MEDIUM));
        slots.add(new ParkingSlot(3, SlotType.LARGE));

        Floor floor = new Floor(1, slots);
        List<Floor> floors = List.of(floor);

        ParkingLotService service = new ParkingLotService(floors, new NearestSlotStrategy());

        Vehicle car = new Vehicle("KA01", VehicleType.CAR);

        Ticket ticket = service.parkVehicle(car);
        System.out.println("Ticket: " + ticket.getTicketId());

        double bill = service.exitVehicle(ticket.getTicketId());
        System.out.println("Bill: " + bill);
    }
}