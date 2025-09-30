package ex1.creational.prototypepattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ContractDocument contractPrototype = new ContractDocument("Standard Contract", "Default terms", "ABC Corp");
        ReportDocument reportPrototype = new ReportDocument("Monthly Report", "Summary data", "John Doe");

        System.out.println("Prototype Pattern Demo: Document Cloning");

        boolean running = true;
        while(running) {
            System.out.println("\nSelect Document to clone: 1. Contract 2. Report 3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    ContractDocument newContract = (ContractDocument) contractPrototype.clone();
                    System.out.print("Enter party name: ");
                    newContract.setPartyName(sc.nextLine());
                    newContract.display();
                    break;
                case 2:
                    ReportDocument newReport = (ReportDocument) reportPrototype.clone();
                    System.out.print("Enter author name: ");
                    newReport.setAuthor(sc.nextLine());
                    newReport.display();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
        System.out.println("Exiting Prototype Demo.");
    }
}
