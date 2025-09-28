package ex1.behavioral.statepattern;

public class NormalState implements TrafficLightState {

    @Override
    public void changeLight(TrafficLightController controller) {
        System.out.println("[Normal Mode] Traffic Light: GREEN → YELLOW → RED");
        try {
            Thread.sleep(1000); // Simulate time delay
        } catch (InterruptedException e) {
            System.err.println("Error in NormalState: " + e.getMessage());
        }
        // Stays in normal unless external event changes
        controller.setState(this);
    }

    @Override
    public String getStateName() {
        return "Normal State";
    }
}
