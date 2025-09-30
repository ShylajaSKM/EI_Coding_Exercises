package ex1.structural.bridgepattern;

import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Shape Drawer");
        ShapeDrawer drawer = ShapeDrawer.getInstance();
        frame.add(drawer);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Draw Circle");
            System.out.println("2. Draw Square");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            if (choice == 3) break;

            System.out.print("Enter x: ");
            int x = sc.nextInt();
            System.out.print("Enter y: ");
            int y = sc.nextInt();
            System.out.print("Enter size/radius: ");
            int size = sc.nextInt();

            System.out.print("Choose platform (1-Windows, 2-Linux): ");
            int platform = sc.nextInt();
            DrawingAPI api = (platform == 1) ? new WindowsAPI() : new LinuxAPI();

            Shape shape;
            if (choice == 1) {
                shape = new Circle(x, y, size, api);
            } else {
                shape = new Square(x, y, size, api);
            }

            // Add to drawer for Swing
            drawer.addShape(shape);

            // Log to console
            shape.draw();
        }

        sc.close();
        System.out.println("Program exited.");
    }
}
