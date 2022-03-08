package main.java.edu.bsu.shapes.entity;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Triangle extends Shape2D{

    private Point pointA;

    private Point pointB;

    private Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public void draw(Graphics graphics) {
        GeneralPath triangle = new GeneralPath();
        Graphics2D graphics2D = (Graphics2D) graphics;
        triangle.moveTo(pointA.x, pointA.y);
        triangle.lineTo(pointB.x, pointB.y);
        triangle.lineTo(pointC.x, pointC.y);
        triangle.lineTo(pointA.x, pointA.y);
        triangle.closePath();
        graphics2D.setColor(getFillColor());
        graphics2D.fill(triangle);
        graphics2D.setColor(getBorderColor());
        graphics2D.draw(triangle);
    }
}
