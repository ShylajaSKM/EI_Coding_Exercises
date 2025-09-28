package ex1.behavioral.statepattern;

public class NightState implements TrafficLightState {

    @Override
    public void changeLight(TrafficLightController controller) {
        System.out.println("[Night Mode] Blinking YELLOW lights for low traffic");
        try {
            Thread.sleep(1000); // Simulate night mode
        } catch (InterruptedException e) {
            System.err.println("Error in NightState: " + e.getMessage());
        }
        // Night mode continues unless overridden
        controller.setState(this);
    }

    @Override
    public String getStateName() {
        return "Night State";
    }
}
