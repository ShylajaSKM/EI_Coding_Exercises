package ex1.behavioral.statepattern;

import java.util.logging.Logger;

public class TrafficLightController {
    private static final Logger logger = Logger.getLogger(TrafficLightController.class.getName());
    private TrafficLightState currentState;

    public TrafficLightController(TrafficLightState initialState) {
        if (initialState == null) throw new IllegalArgumentException("Initial state cannot be null");
        this.currentState = initialState;
    }

    public void setState(TrafficLightState newState) {
        if (newState == null) {
            logger.severe("Cannot set null state");
            throw new IllegalArgumentException("New state cannot be null");
        }
        logger.info("Transitioning to: " + newState.getStateName());
        this.currentState = newState;
    }

    public void execute() {
        try {
            currentState.handle(this);
        } catch (Exception e) {
            logger.severe("Error executing state " + currentState.getStateName() + ": " + e.getMessage());
        }
    }

    public String getCurrentStateName() {
        return currentState.getStateName();
    }
}
