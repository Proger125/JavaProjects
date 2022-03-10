package main.java.edu.bsu.figures.entity;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.List;

public class Polygon extends Figure2D{

    private List<Point> points;

    public Polygon(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public void draw(Graphics graphics) {
        GeneralPath polygon = new GeneralPath();
        polygon.moveTo(points.get(0).x, points.get(0).y);
        for (int i = 1; i < points.size(); i++) {
            polygon.lineTo(points.get(i).x, points.get(i).y);
        }
        polygon.lineTo(points.get(0).x, points.get(0).y);
        polygon.closePath();
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(getFillColor());
        graphics2D.fill(polygon);
        graphics2D.setColor(getBorderColor());
        graphics2D.draw(polygon);
    }
}
