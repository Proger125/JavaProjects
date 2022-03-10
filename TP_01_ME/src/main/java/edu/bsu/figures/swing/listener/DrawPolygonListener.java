package main.java.edu.bsu.figures.swing.listener;

import main.java.edu.bsu.figures.entity.Polygon;
import main.java.edu.bsu.figures.swing.config.DrawConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static main.java.edu.bsu.figures.swing.config.Graphic.*;
import static main.java.edu.bsu.figures.util.PointCreator.createPoint;

public class DrawPolygonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            List<Point> points = new ArrayList<>();
            for (int i = 0; i < POINTS_FIELDS.size(); i += 2) {
                points.add(createPoint(POINTS_FIELDS.get(i), POINTS_FIELDS.get(i + 1)));
            }
            Polygon polygon = new Polygon(points);
            polygon.setBorderColor(DrawConfig.getBorderColor());
            polygon.setFillColor(DrawConfig.getFillColor());
            polygon.draw(DRAW_PANEL.getGraphics());
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
