EI Coding Assessment (Shylaja.SKM)

Exercise 1 – Design Patterns

1. Behavioural Pattern

   a. Chain of Responsibility
   - SupportHandler.java: Defines the interface for handling requests.
   - SupportTicket.java: Represents the request class.
   - Level1Handler.java, Level2Handler.java, Level3Handler.java: Concrete handlers for different support levels.
   - Main.java: Client program demonstrating the chain of responsibility pattern with user input.

   Run:
   ```
   javac ex1/behavioral/chainofresponsibility/Main.java
   java ex1.behavioral.chainofresponsibility.Main
   ```

   b. State Pattern
   - TrafficLightState.java: Interface for all traffic light states
   - NormalState.java: Green-Yellow-Red cycle (default operation)
   - PedestrianState.java: Pedestrian crossing mode
   - EmergencyState.java: Emergency mode (priority to emergency vehicles)
   - NightState.java: Night mode (blinking yellow)
   - TrafficLightController.java: Maintains current state and transitions
   - Main.java: Entry point to run and test the system

2. Creational Pattern

   a. Prototype Pattern
   - Document.java: Abstract base class defining the clone() method.
   - ContractDocument.java / ReportDocument.java: Concrete prototypes implementing cloning.
   - DocumentPrototype.java: Helper for managing registered prototypes.
   - Main.java: Demonstrates cloning and modifying documents dynamically.

   b. Object Pool Pattern
   - DatabaseConnection.java: Simulated connection class with unique ID and query execution.
   - ConnectionPool.java: Manages a pool of reusable connections (borrow/return).
   - Main.java: Interactive demo to borrow, return, and execute queries with pooled connections.

3. Structural Pattern

   a. Bridge Pattern
   - Shape.java: Abstract shape class using DrawingAPI.
   - DrawingAPI.java: Interface for drawing (implementor).
   - Circle.java / Square.java: Concrete shapes.
   - WindowsAPI.java / LinuxAPI.java: Concrete drawing implementations.
   - ShapeDrawer.java: Swing panel for drawing shapes.
   - Main.java: Creates a window, initializes shapes, and draws them.

   b. Decorator Pattern
   - Text.java: Interface for text operations.
   - ConcreteText.java: Core text class.
   - Decorator.java: Abstract decorator holding a Text reference.
   - BoldText.java / ItalicText.java / UnderlineText.java: Concrete decorators adding styles.
   - Main.java: GUI for entering text and selecting styles (bold/italic/underline).

Exercise 2

Smart Home System
- Main.java: Entry point of the application.
- SmartHomeSystem.java: Central hub managing devices, schedules, triggers.
- DeviceProxy.java: Proxy pattern to control device access.
- Device.java: Abstract base class for devices.
- DeviceFactory.java: Factory pattern to create devices.
- DeviceObserver.java: Observer interface for device state change notifications.
- Light.java / ThermoStat.java / DoorLock.java: Device implementations.
- ScheduledTask.java / AutomatedTrigger.java: Scheduled and automated triggers respectively.

