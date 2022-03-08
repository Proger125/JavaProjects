package main.java.edu.bsu.shapes.entity;

import java.awt.*;

public abstract class Shape2D extends Shape{

    private Color fillColor;

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
}
