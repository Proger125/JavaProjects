package main.java.edu.bsu.figures.entity;

import java.awt.*;

public abstract class Figure2D extends Figure{
    private Color fillColor;

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
}
