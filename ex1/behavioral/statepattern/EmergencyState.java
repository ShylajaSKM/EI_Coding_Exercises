package ex1.behavioral.statepattern;

import java.util.logging.Logger;

public class EmergencyState implements TrafficLightState {
    private static final Logger logger = Logger.getLogger(EmergencyState.class.getName());

    @Override
    public void handle(TrafficLightController controller) {
        logger.warning("Emergency Mode: All signals RED, clear the road for emergency vehicles");
    }

    @Override
    public String getStateName() {
        return "Emergency Mode";
    }
}
