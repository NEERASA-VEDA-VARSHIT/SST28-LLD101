# 🛗 Elevator System - Low Level Design

## 🎯 Overview
This project models a multi-elevator system with:
- Multiple elevators
- External and internal requests
- Elevator selection strategy
- Basic scheduling using request queues

---

## 🧱 System Design

The system is divided into layers:

### 📦 Enums
- `Direction` → UP, DOWN
- `ElevatorState` → MOVING_UP, MOVING_DOWN, IDLE, MAINTENANCE

---

### 🚗 Model Layer
- `Elevator`
  - Represents a single elevator
  - Maintains:
    - current floor
    - state
    - up/down request queues

---

### 🧠 Strategy Layer
- `ElevatorSelectionStrategy` (interface)
  - Defines how elevators are selected

- `NearestElevatorStrategy`
  - Chooses elevator closest to request floor

---

### ⚙️ Service Layer
- `ElevatorController`
  - Assigns elevators to requests
  - Delegates selection to strategy

---

### ▶️ Entry Point
- `Main`
  - Simulates requests and system behavior

---

## 🧠 Design Principles

- **Single Responsibility Principle**
  - Each class has a clear role

- **Open/Closed Principle**
  - New strategies can be added without modifying existing code

- **Strategy Pattern**
  - Used for elevator selection

---

## ⚠️ Tradeoffs

- Selection is distance-based only (ignores direction/state)
- Scheduling is simplified
- No concurrency handling
- No real-time simulation loop

---

## 🚀 Future Improvements

- Add Scheduler (SCAN / LOOK algorithm)
- Handle internal vs external requests separately
- Add weight constraint handling
- Add maintenance mode handling
- Improve elevator selection logic

---

## 📂 Project Structure
```
Elevator/
├── src/
│   ├── enums/        # Direction, ElevatorState
│   ├── model/        # Core entities (Elevator)
│   ├── service/      # Controller (business logic)
│   └── strategy/     # Selection strategy
├── design/
│   └── design.md     # UML + system design
└── README.md         # Project overview
```