package ex1.behavioral.chainofresponsibility;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Setup chain: Level 1 → Level 2 → Level 3
        Level1Handler level1 = new Level1Handler();
        Level2Handler level2 = new Level2Handler();
        Level3Handler level3 = new Level3Handler();

        level1.setNextHandler(level2);
        level2.setNextHandler(level3);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("==== Customer Support Ticket System ====");

        while (running) {
            System.out.println("\nEnter ticket description:");
            String desc = scanner.nextLine();

            System.out.println("Enter ticket complexity (1-Simple, 2-Moderate, 3-Complex, 0-Exit):");
            int complexity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (complexity == 0) {
                running = false;
                System.out.println("Exiting program...");
            } else if (complexity < 0 || complexity > 3) {
                System.out.println("Invalid complexity level! Try again.");
            } else {
                Ticket ticket = new Ticket(desc, complexity);
                level1.handleTicket(ticket);
            }
        }

        scanner.close();
    }
}
