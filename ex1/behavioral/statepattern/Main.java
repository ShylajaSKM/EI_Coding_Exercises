package ex1.behavioral.statepattern;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrafficLightController controller = new TrafficLightController(new NormalState());

        logger.info("Smart Traffic Light System Started");
        logger.info("Modes: normal, pedestrian, emergency, night, exit");

        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Enter mode: ");
            String input = scanner.nextLine().trim().toLowerCase();

            try {
                switch (input) {
                    case "normal":
                        controller.setState(new NormalState());
                        break;
                    case "pedestrian":
                        controller.setState(new PedestrianState());
                        break;
                    case "emergency":
                        controller.setState(new EmergencyState());
                        break;
                    case "night":
                        controller.setState(new NightState());
                        break;
                    case "exit":
                        logger.info("System shutting down...");
                        isRunning = false;
                        continue;
                    default:
                        logger.warning("Invalid mode! Try again.");
                        continue;
                }
                controller.execute();
            } catch (Exception e) {
                logger.severe("Unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
