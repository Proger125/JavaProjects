package main.java.edu.bsu.shapes.entity;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Rectangle extends Shape2D{

    private Point pointA;

    private Point pointB;

    private Point pointC;

    private Point pointD;

    public Rectangle(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
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

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }

    @Override
    public void draw(Graphics graphics) {
        GeneralPath rectangle = new GeneralPath();
        rectangle.moveTo(pointA.x, pointA.y);
        rectangle.lineTo(pointB.x, pointB.y);
        rectangle.lineTo(pointC.x, pointC.y);
        rectangle.lineTo(pointD.x, pointD.y);
        rectangle.lineTo(pointA.x, pointA.y);
        rectangle.closePath();
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(getFillColor());
        graphics2D.fill(rectangle);
        graphics2D.setColor(getBorderColor());
        graphics2D.draw(rectangle);
    }
}
