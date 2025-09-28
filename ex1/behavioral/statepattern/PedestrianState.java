package ex1.behavioral.statepattern;

public class PedestrianState implements TrafficLightState {

    @Override
    public void changeLight(TrafficLightController controller) {
        System.out.println("[Pedestrian Crossing] RED lights for vehicles, pedestrians walk");
        try {
            Thread.sleep(1000); // Simulate pedestrian crossing
        } catch (InterruptedException e) {
            System.err.println("Error in PedestrianState: " + e.getMessage());
        }
        // After pedestrian crossing, return to normal
        controller.setState(new NormalState());
    }

    @Override
    public String getStateName() {
        return "Pedestrian Crossing State";
    }
}
