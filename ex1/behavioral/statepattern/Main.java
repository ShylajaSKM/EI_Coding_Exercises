package ex1.behavioral.statepattern;

public class Main {
    public static void main(String[] args) {
        TrafficLightController controller = new TrafficLightController(new NormalState());
        controller.run();
    }
}
