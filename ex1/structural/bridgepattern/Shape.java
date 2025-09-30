package ex1.structural.bridgepattern;

import java.awt.Graphics;

public abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        if (drawingAPI == null) {
            throw new IllegalArgumentException("DrawingAPI cannot be null");
        }
        this.drawingAPI = drawingAPI;
    }

    // Console logging
    public abstract void draw();

    // Swing drawing
    public abstract void draw(Graphics g);
}
