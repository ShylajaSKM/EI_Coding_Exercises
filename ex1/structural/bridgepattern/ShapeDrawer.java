package ex1.structural.bridgepattern;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ShapeDrawer extends JPanel {
    private static ShapeDrawer instance;
    private final List<Shape> shapes = new ArrayList<>();

    private ShapeDrawer() {}

    public static ShapeDrawer getInstance() {
        if (instance == null) {
            instance = new ShapeDrawer();
        }
        return instance;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
        repaint(); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapes) {
            s.draw(g);
        }
    }
}
