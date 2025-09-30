package ex1.creational.objectpoolpattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConnectionPool pool = new ConnectionPool(3);

        boolean running = true;
        while(running) {
            System.out.println("\nObject Pool Demo: Connections available = " + pool.availableConnections());
            System.out.println("1. Borrow Connection 2. Return Connection 3. Execute Query 4. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            DatabaseConnection conn = null;
            switch(choice) {
                case 1:
                    conn = pool.borrowConnection();
                    break;
                case 2:
                    System.out.print("Enter connection ID to return: ");
                    int id = sc.nextInt();
                    // In real scenario, we’d track connections. Here, simulate returning a new one:
                    conn = new DatabaseConnection();
                    pool.returnConnection(conn);
                    break;
                case 3:
                    System.out.print("Enter query: ");
                    String query = sc.nextLine();
                    conn = pool.borrowConnection();
                    if(conn != null) {
                        conn.executeQuery(query);
                        pool.returnConnection(conn);
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
        System.out.println("Exiting Object Pool Demo.");
    }
}
