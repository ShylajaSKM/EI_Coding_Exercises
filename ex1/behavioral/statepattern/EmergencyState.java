package ex1.behavioral.statepattern;

public class EmergencyState implements TrafficLightState {

    @Override
    public void changeLight(TrafficLightController controller) {
        System.out.println("[Emergency Mode] GREEN lights in emergency direction");
        try {
            Thread.sleep(1000); // Simulate emergency
        } catch (InterruptedException e) {
            System.err.println("Error in EmergencyState: " + e.getMessage());
        }
        // Return to normal after emergency
        controller.setState(new NormalState());
    }

    @Override
    public String getStateName() {
        return "Emergency Vehicle State";
    }
}
