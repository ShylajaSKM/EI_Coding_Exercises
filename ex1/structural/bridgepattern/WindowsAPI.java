package ex1.structural.bridgepattern;

public class WindowsAPI implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Drawing Circle on Windows at (" + x + "," + y + ") with radius " + radius);
    }

    @Override
    public void drawSquare(int x, int y, int side) {
        System.out.println("Drawing Square on Windows at (" + x + "," + y + ") with side " + side);
    }
}
