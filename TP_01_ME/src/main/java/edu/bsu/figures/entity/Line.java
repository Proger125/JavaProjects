package main.java.edu.bsu.figures.entity;

import java.awt.*;

public class Line extends Ray{
    public Line(Point firstPoint, Point secondPoint) {
        super(firstPoint, secondPoint);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        Point point = getSecondPoint();
        setSecondPoint(getFirstPoint());
        setFirstPoint(point);
        super.draw(graphics);
    }
}
