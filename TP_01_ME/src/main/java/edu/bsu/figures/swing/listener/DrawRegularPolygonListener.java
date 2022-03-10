package main.java.edu.bsu.figures.swing.listener;

import main.java.edu.bsu.figures.entity.RegularPolygon;
import main.java.edu.bsu.figures.swing.config.DrawConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.edu.bsu.figures.swing.config.Graphic.*;
import static main.java.edu.bsu.figures.util.IntegerCreator.createInteger;
import static main.java.edu.bsu.figures.util.PointCreator.createPoint;

public class DrawRegularPolygonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Point center = createPoint(CENTER_POINT_X_FIELD, CENTER_POINT_Y_FIELD);
            int radius = createInteger(RADIUS_FIELD);
            int angles = createInteger(ANGLES_AMOUNT_FIELD);
            RegularPolygon regularPolygon = new RegularPolygon(center, radius, angles);
            regularPolygon.setBorderColor(DrawConfig.getBorderColor());
            regularPolygon.setFillColor(DrawConfig.getFillColor());
            regularPolygon.draw(DRAW_PANEL.getGraphics());
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
