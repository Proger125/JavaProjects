package main.java.edu.bsu.figures.entity;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class RegularPolygon extends Figure2D{

    private Point center;
    private int radius;
    private int angleAmount;

    public RegularPolygon(Point center, int radius, int angleAmount) {
        this.center = center;
        this.radius = radius;
        this.angleAmount = angleAmount;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getAngleAmount() {
        return angleAmount;
    }

    public void setAngleAmount(int angleAmount) {
        this.angleAmount = angleAmount;
    }

    @Override
    public void draw(Graphics graphics) {
        GeneralPath polygon = new GeneralPath();
        polygon.moveTo(center.x + radius, center.y);
        for (int i = 1; i < angleAmount; i++) {
            double angle = 2 * Math.PI * i / angleAmount;
            int pointX = (int) (radius * Math.cos(angle) + center.x);
            int pointY = (int) (radius * Math.sin(angle) + center.y);
            polygon.lineTo(pointX, pointY);
        }
        polygon.lineTo(center.x + radius, center.y);
        polygon.closePath();
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(getFillColor());
        graphics2D.fill(polygon);
        graphics2D.setColor(getBorderColor());
        graphics2D.draw(polygon);
    }
}
