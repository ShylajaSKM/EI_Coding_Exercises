package ex1.behavioral.statepattern;

import java.util.logging.Logger;

public class NightState implements TrafficLightState {
    private static final Logger logger = Logger.getLogger(NightState.class.getName());

    @Override
    public void handle(TrafficLightController controller) {
        logger.info("Night Mode: Blinking YELLOW for caution");
    }

    @Override
    public String getStateName() {
        return "Night Mode";
    }
}
