package main.java.edu.bsu.shapes.entity;

import java.awt.*;

public abstract class Shape {

    private Color borderColor;

    public abstract void draw(Graphics graphics);

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
}
