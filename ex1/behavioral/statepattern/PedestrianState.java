package ex1.behavioral.statepattern;

import java.util.logging.Logger;

public class PedestrianState implements TrafficLightState {
    private static final Logger logger = Logger.getLogger(PedestrianState.class.getName());

    @Override
    public void handle(TrafficLightController controller) {
        logger.info("Traffic Light: PEDESTRIAN mode, stop vehicles, allow crossing");
    }

    @Override
    public String getStateName() {
        return "Pedestrian Mode";
    }
}
