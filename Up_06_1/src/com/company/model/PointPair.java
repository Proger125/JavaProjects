package com.company.model;

import java.awt.*;

public class PointPair {
    private Point currentPoint;
    private Point correctPoint;

    public PointPair(Point currentPoint, Point correctPoint) {
        this.currentPoint = currentPoint;
        this.correctPoint = correctPoint;
    }

    public Point getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Point currentPoint) {
        this.currentPoint = currentPoint;
    }

    public Point getCorrectPoint() {
        return correctPoint;
    }

    public void setCorrectPoint(Point correctPoint) {
        this.correctPoint = correctPoint;
    }
}
