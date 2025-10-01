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
<img width="838" height="289" alt="chainofresponsibility" src="https://github.com/user-attachments/assets/be26f40d-4135-41a0-961f-fbe5348097a9" />

   b. State Pattern
   - TrafficLightState.java: Interface for all traffic light states
   - NormalState.java: Green-Yellow-Red cycle (default operation)
   - PedestrianState.java: Pedestrian crossing mode
   - EmergencyState.java: Emergency mode (priority to emergency vehicles)
   - NightState.java: Night mode (blinking yellow)
   - TrafficLightController.java: Maintains current state and transitions
   - Main.java: Entry point to run and test the system

     
<img width="779" height="451" alt="statepattern" src="https://github.com/user-attachments/assets/40897c92-6e0b-4a0e-b57e-6df8651e7cfc" />

2. Creational Pattern

   a. Prototype Pattern
   - Document.java: Abstract base class defining the clone() method.
   - ContractDocument.java / ReportDocument.java: Concrete prototypes implementing cloning.
   - DocumentPrototype.java: Helper for managing registered prototypes.
   - Main.java: Demonstrates cloning and modifying documents dynamically.

<img width="723" height="463" alt="prototypepattern" src="https://github.com/user-attachments/assets/ee8d80ef-13f1-43f4-afe1-a496a19e6c0e" />

   b. Object Pool Pattern
   - DatabaseConnection.java: Simulated connection class with unique ID and query execution.
   - ConnectionPool.java: Manages a pool of reusable connections (borrow/return).
   - Main.java: Interactive demo to borrow, return, and execute queries with pooled connections.
<img width="680" height="415" alt="objectpoolpattern" src="https://github.com/user-attachments/assets/0927810b-0d15-4c71-b882-e075f83e8372" />




2. Structural Pattern

   a. Bridge Pattern
   - Shape.java: Abstract shape class using DrawingAPI.
   - DrawingAPI.java: Interface for drawing (implementor).
   - Circle.java / Square.java: Concrete shapes.
   - WindowsAPI.java / LinuxAPI.java: Concrete drawing implementations.
   - ShapeDrawer.java: Swing panel for drawing shapes.
   - Main.java: Creates a window, initializes shapes, and draws them.
     <img width="732" height="260" alt="bridgepattern" src="https://github.com/user-attachments/assets/b45aa626-0705-418f-b630-4fe4e444372f" />
     
     <img width="204" height="165" alt="shapes" src="https://github.com/user-attachments/assets/f8fba477-07f6-4202-8149-c21c582149ec" />



   b. Decorator Pattern
   - Text.java: Interface for text operations.
   - ConcreteText.java: Core text class.
   - Decorator.java: Abstract decorator holding a Text reference.
   - BoldText.java / ItalicText.java / UnderlineText.java: Concrete decorators adding styles.
   - Main.java: GUI for entering text and selecting styles (bold/italic/underline).
   <img width="355" height="357" alt="decoratorpattern" src="https://github.com/user-attachments/assets/72d8991b-e3dd-4ca7-8cd1-5673a6759449" />
   <img width="468" height="221" alt="decoratotoutput" src="https://github.com/user-attachments/assets/f14d8b87-28d1-4896-a803-02467c2a0db6" />

 

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
  <img width="1073" height="599" alt="Screenshot 2025-10-01 211306" src="https://github.com/user-attachments/assets/bf7c54de-163c-4d65-bd48-1ec72c4a5eab" />
  <img width="694" height="556" alt="Screenshot 2025-10-01 211508" src="https://github.com/user-attachments/assets/229db5eb-d0a9-4ff5-921e-5ec05ed2e081" />


  

