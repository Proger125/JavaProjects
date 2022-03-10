package main.java.edu.bsu.figures.util;

import javax.swing.*;
import java.awt.*;

import static main.java.edu.bsu.figures.swing.config.Graphic.DRAW_PANEL;
import static main.java.edu.bsu.figures.validator.IntegerValidator.validateInt;

public final class PointCreator {

    public static Point createPoint(JTextField pointXField, JTextField pointYField) {
        String pointX = pointXField.getText();
        String pointY = pointYField.getText();

        validateInt(pointX);
        validateInt(pointY);

        int x = Integer.parseInt(pointX);
        int y = Integer.parseInt(pointY);
        if (x > DRAW_PANEL.getWidth() || y > DRAW_PANEL.getHeight()) {
            throw new IllegalArgumentException("Incorrect input data");
        }

        return new Point(x, y);
    }
    private PointCreator(){}
}
