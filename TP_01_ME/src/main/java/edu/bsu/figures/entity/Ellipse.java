package main.java.edu.bsu.figures.entity;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Figure2D{

    private Point center;
    private int verticalRadius;
    private int horizontalRadius;

    public Ellipse(Point center, int verticalRadius, int horizontalRadius) {
        this.center = center;
        this.verticalRadius = verticalRadius;
        this.horizontalRadius = horizontalRadius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getVerticalRadius() {
        return verticalRadius;
    }

    public void setVerticalRadius(int verticalRadius) {
        this.verticalRadius = verticalRadius;
    }

    public int getHorizontalRadius() {
        return horizontalRadius;
    }

    public void setHorizontalRadius(int horizontalRadius) {
        this.horizontalRadius = horizontalRadius;
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        Ellipse2D ellipse2D = new Ellipse2D.Double(center.x - horizontalRadius, center.y - verticalRadius, 2 * horizontalRadius, 2 * verticalRadius);
        graphics2D.setColor(getFillColor());
        graphics2D.fill(ellipse2D);
        graphics2D.setColor(getBorderColor());
        graphics2D.draw(ellipse2D);
    }
}
