package ex1.behavioral.statepattern;

import java.util.logging.Logger;

public class NormalState implements TrafficLightState {
    private static final Logger logger = Logger.getLogger(NormalState.class.getName());

    @Override
    public void handle(TrafficLightController controller) {
        logger.info("Traffic Light: GREEN -> YELLOW -> RED");
    }

    @Override
    public String getStateName() {
        return "Normal Mode";
    }
}
