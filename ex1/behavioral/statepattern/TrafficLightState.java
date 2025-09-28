package ex1.behavioral.statepattern;

public interface TrafficLightState {
    void changeLight(TrafficLightController controller);
    String getStateName();
}

