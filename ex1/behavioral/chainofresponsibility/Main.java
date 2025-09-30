package ex1.behavioral.chainofresponsibility;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Setup chain
        SupportHandler level1 = new Level1Handler();
        SupportHandler level2 = new Level2Handler();
        SupportHandler level3 = new Level3Handler();

        level1.setNextHandler(level2);
        level2.setNextHandler(level3);

        logger.info("Customer Support System Started. Enter 'exit' to quit.");

        boolean running = true;
        while (running) {
            System.out.print("Enter ticket description: ");
            String desc = scanner.nextLine();
            if ("exit".equalsIgnoreCase(desc)) break;

            System.out.print("Enter complexity (1-3): ");
            String compStr = scanner.nextLine();
            int complexity;
            try {
                complexity = Integer.parseInt(compStr);
            } catch (NumberFormatException e) {
                logger.warning("Invalid complexity! Defaulting to 1");
                complexity = 1;
            }

            SupportTicket ticket = new SupportTicket(desc, complexity);
            level1.handleRequest(ticket);
        }

        scanner.close();
        logger.info("System shutting down...");
    }
}
