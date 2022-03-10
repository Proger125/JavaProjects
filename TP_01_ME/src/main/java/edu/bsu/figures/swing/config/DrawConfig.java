package main.java.edu.bsu.figures.swing.config;

import java.awt.*;

public final class DrawConfig {

    private static Figure figure;
    private static Color borderColor;
    private static Color fillColor;

    public static Figure getFigure() {
        return figure;
    }

    public static void setFigure(Figure figure) {
        DrawConfig.figure = figure;
    }

    public static Color getBorderColor() {
        return borderColor;
    }

    public static void setBorderColor(Color borderColor) {
        DrawConfig.borderColor = borderColor;
    }

    public static Color getFillColor() {
        return fillColor;
    }

    public static void setFillColor(Color fillColor) {
        DrawConfig.fillColor = fillColor;
    }

    private DrawConfig() {}
}
