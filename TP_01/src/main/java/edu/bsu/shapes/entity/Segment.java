package main.java.edu.bsu.shapes.entity;

import java.awt.*;

public class Segment extends Shape {

    private Point firstPoint;

    private Point secondPoint;

    public Segment(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(getBorderColor());
        graphics.drawLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
    }
}
