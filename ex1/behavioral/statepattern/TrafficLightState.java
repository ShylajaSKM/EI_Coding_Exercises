package ex1.behavioral.statepattern;

public interface TrafficLightState {
    void handle(TrafficLightController controller);
    String getStateName();
}
