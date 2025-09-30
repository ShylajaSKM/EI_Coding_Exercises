package ex1.structural.bridgepattern;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {
    private int x, y, side;

    public Square(int x, int y, int side, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.side = side;
    }

    @Override
    public void draw() {
        drawingAPI.drawSquare(x, y, side);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, side, side);
    }
}
