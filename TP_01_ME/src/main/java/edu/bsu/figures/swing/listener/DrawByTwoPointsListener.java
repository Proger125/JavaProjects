package main.java.edu.bsu.figures.swing.listener;

import main.java.edu.bsu.figures.entity.Figure;
import main.java.edu.bsu.figures.entity.Line;
import main.java.edu.bsu.figures.entity.Ray;
import main.java.edu.bsu.figures.entity.Segment;
import main.java.edu.bsu.figures.swing.config.DrawConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.edu.bsu.figures.swing.config.Graphic.*;
import static main.java.edu.bsu.figures.util.PointCreator.createPoint;

public class DrawByTwoPointsListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Point firstPoint = createPoint(POINTS_FIELDS.get(0), POINTS_FIELDS.get(1));
            Point secondPoint = createPoint(POINTS_FIELDS.get(2), POINTS_FIELDS.get(3));

            Figure figure;
            switch (DrawConfig.getFigure()) {
                case SEGMENT:
                    figure = new Segment(firstPoint, secondPoint);
                    break;
                case RAY:
                    figure = new Ray(firstPoint, secondPoint);
                    break;
                case LINE:
                    figure = new Line(firstPoint, secondPoint);
                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Figure wasn't selected",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
            }
            figure.setBorderColor(DrawConfig.getBorderColor());
            figure.draw(DRAW_PANEL.getGraphics());
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
