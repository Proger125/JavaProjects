package main.java.edu.bsu.figures.entity;

import java.awt.*;

public abstract class Figure {

    private Color borderColor;

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public abstract void draw(Graphics graphics);
}
