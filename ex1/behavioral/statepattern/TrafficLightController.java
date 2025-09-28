
package ex1.behavioral.statepattern;
import java.util.Scanner;

public class TrafficLightController {
    private TrafficLightState currentState;

    public TrafficLightController(TrafficLightState initialState) {
        this.currentState = initialState;
    }

    public void setState(TrafficLightState state) {
        System.out.println("Transitioning to: " + state.getStateName());
        this.currentState = state;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nCurrent State: " + currentState.getStateName());
            System.out.println("Choose event: 1-Pedestrian 2-Emergency 3-Night 4-Normal 5-Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> currentState = new PedestrianState();
                case 2 -> currentState = new EmergencyState();
                case 3 -> currentState = new NightState();
                case 4 -> currentState = new NormalState();
                case 5 -> running = false;
                default -> System.out.println("Invalid input. Try again.");
            }

            if (running) {
                currentState.changeLight(this);
            }
        }

        System.out.println("Traffic Light System Stopped.");
        scanner.close();
    }
}
