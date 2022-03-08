package main.java.edu.bsu.shapes.swing.config;

import java.awt.*;

public final class DrawConfig {

    private static Figure figure;

    private static Color borderColor = Color.BLACK;

    private static Color fillColor = Color.BLACK;

    public static Color getFillColor() {
        return fillColor;
    }

    public static void setFillColor(Color fillColor) {
        DrawConfig.fillColor = fillColor;
    }

    public static Figure getFigure() {
        return figure;
    }

    public static void setFigure(Figure f) {
        figure = f;
    }

    public static void setBorderColor(Color borderColor) {
        DrawConfig.borderColor = borderColor;
    }

    public static Color getBorderColor() {
        return borderColor;
    }

    private DrawConfig(){}
}
