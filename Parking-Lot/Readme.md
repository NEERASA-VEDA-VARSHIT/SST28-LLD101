# 🚗 Parking Lot LLD

## 🎯 Overview
This project models a multi-level parking lot system supporting:
- Multiple floors
- Different vehicle types
- Slot allocation
- Ticket generation
- Billing on exit

---

## 📦 Enums (Foundation Layer)

### VehicleType
Defines types of vehicles:
- BIKE
- CAR
- TRUCK

### SlotType
Defines types of parking slots:
- SMALL
- MEDIUM
- LARGE

---

## 🚗 Core Models (Data Layer)

### Vehicle
Represents a vehicle entering the parking lot.

### ParkingSlot
Represents a single parking slot with type and occupancy status.

### Floor
Represents a parking floor containing multiple slots.

### Ticket
Generated at entry; stores vehicle, assigned slot, and entry time.

---

## 🧠 Strategy Layer (Extensibility)

### SlotAllocationStrategy
Interface defining contract for slot allocation.

### NearestSlotStrategy
Simple implementation that assigns the first available slot.

---

## ⚙️ Service Layer (Business Logic)

### ParkingLotService
Handles:
- Parking vehicles
- Ticket creation
- Vehicle exit
- Billing calculation

---

## ▶️ Entry Point

### Main
Simulates system flow:
- Initializes parking lot
- Parks vehicle
- Exits vehicle
- Prints bill

---

## ⚠️ Design Tradeoffs

- Nearest slot uses linear scan (not distance-based)
- Billing uses simple hourly model
- No concurrency handling
- No gate modeling

> Design prioritizes simplicity and readability while maintaining extensibility using the Strategy pattern.