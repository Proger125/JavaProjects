package main.java.edu.bsu.figures.swing.listener;

import main.java.edu.bsu.figures.entity.Ellipse;
import main.java.edu.bsu.figures.swing.config.DrawConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.edu.bsu.figures.swing.config.Graphic.*;
import static main.java.edu.bsu.figures.util.PointCreator.createPoint;
import static main.java.edu.bsu.figures.util.IntegerCreator.createInteger;

public class DrawEllipseListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Point center = createPoint(CENTER_POINT_X_FIELD, CENTER_POINT_Y_FIELD);
            int horizontalRadius = createInteger(HORIZONTAL_RADIUS_FIELD);
            int verticalRadius = createInteger(VERTICAL_RADIUS_FIELD);
            Ellipse ellipse = new Ellipse(center, verticalRadius, horizontalRadius);
            ellipse.setBorderColor(DrawConfig.getBorderColor());
            ellipse.setFillColor(DrawConfig.getFillColor());
            ellipse.draw(DRAW_PANEL.getGraphics());
            OPTIONS_FRAME.dispose();
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(
                    null,
                    "Incorrect input data",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }


    }
}
