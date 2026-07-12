# 🧠 Elevator System - Design (UML + Responsibilities)

---

## 📌 Overview

This document describes the class-level design and interactions of the elevator system.

---

# 🧩 1. Responsibilities

## Elevator
- Maintains:
  - current floor
  - state
  - request queues
- Executes movement

## ElevatorController
- Central brain of the system
- Assigns elevator to requests
- Uses strategy for selection

## ElevatorSelectionStrategy
- Interface for selecting best elevator

## NearestElevatorStrategy
- Selects closest elevator

## Enums
- Direction → UP, DOWN
- ElevatorState → MOVING_UP, MOVING_DOWN, IDLE, MAINTENANCE

---

# 🔗 2. Relationships

- ElevatorController → uses → ElevatorSelectionStrategy
- ElevatorController → manages → Elevator
- ElevatorSelectionStrategy → implemented by → NearestElevatorStrategy

---

# 🧩 3. Class Diagram

```mermaid
classDiagram

class ElevatorController {
  - List<Elevator> elevators
  - ElevatorSelectionStrategy strategy
  + requestElevator(int)
}

class Elevator {
  - int id
  - int currentFloor
  - ElevatorState state
  - TreeSet upRequests
  - TreeSet downRequests
  + addRequest(int)
  + move()
}

class ElevatorSelectionStrategy {
  <<interface>>
  + selectElevator(List~Elevator~, int)
}

class NearestElevatorStrategy {
  + selectElevator(List~Elevator~, int)
}

ElevatorController --> Elevator
ElevatorController --> ElevatorSelectionStrategy
ElevatorSelectionStrategy <|-- NearestElevatorStrategy