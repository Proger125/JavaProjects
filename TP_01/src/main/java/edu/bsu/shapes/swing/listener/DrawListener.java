package main.java.edu.bsu.shapes.swing.listener;

import main.java.edu.bsu.shapes.entity.Line;
import main.java.edu.bsu.shapes.entity.Ray;
import main.java.edu.bsu.shapes.entity.Segment;
import main.java.edu.bsu.shapes.swing.config.DrawConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.edu.bsu.shapes.swing.config.AllItems.*;
import static main.java.edu.bsu.shapes.validator.CoordinateValidator.validateCoordinate;

public class DrawListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics graphics = DRAW_PANEL.getGraphics();
        switch (DrawConfig.getFigure()) {
            case RAY:
                Ray ray = createRayFromInputData();
                ray.setBorderColor(DrawConfig.getBorderColor());
                ray.draw(graphics);
                break;
            case SEGMENT:
                Segment segment = createSegmentFromInputData();
                segment.setBorderColor(DrawConfig.getBorderColor());
                segment.draw(graphics);
                break;
            case LINE:
                Line line = createLineFromInputData();
                line.setBorderColor(DrawConfig.getBorderColor());
                line.draw(graphics);
                break;
        }
        DRAW_PANEL.invalidate();
        DRAW_PANEL.validate();
    }

    private Ray createRayFromInputData() {
        String firstPointX = getInputDataFromTextField(FIRST_POINT_X_FIELD);
        String firstPointY = getInputDataFromTextField(FIRST_POINT_Y_FIELD);
        String secondPointX = getInputDataFromTextField(SECOND_POINT_X_FIELD);
        String secondPointY = getInputDataFromTextField(SECOND_POINT_Y_FIELD);

        Point firstPoint = createPoint(firstPointX, firstPointY);
        Point secondPoint = createPoint(secondPointX, secondPointY);
        return new Ray(firstPoint, secondPoint);
    }

    private Segment createSegmentFromInputData() {
        String firstPointX = getInputDataFromTextField(FIRST_POINT_X_FIELD);
        String firstPointY = getInputDataFromTextField(FIRST_POINT_Y_FIELD);
        String secondPointX = getInputDataFromTextField(SECOND_POINT_X_FIELD);
        String secondPointY = getInputDataFromTextField(SECOND_POINT_Y_FIELD);

        Point firstPoint = createPoint(firstPointX, firstPointY);
        Point secondPoint = createPoint(secondPointX, secondPointY);
        return new Segment(firstPoint, secondPoint);
    }

    private Line createLineFromInputData() {
        String firstPointX = getInputDataFromTextField(FIRST_POINT_X_FIELD);
        String firstPointY = getInputDataFromTextField(FIRST_POINT_Y_FIELD);
        String secondPointX = getInputDataFromTextField(SECOND_POINT_X_FIELD);
        String secondPointY = getInputDataFromTextField(SECOND_POINT_Y_FIELD);

        Point firstPoint = createPoint(firstPointX, firstPointY);
        Point secondPoint = createPoint(secondPointX, secondPointY);
        return new Line(firstPoint, secondPoint);
    }

    private Point createPoint(String pointX, String pointY) {
        validateCoordinate(pointX);
        validateCoordinate(pointY);

        int x = Integer.parseInt(pointX);
        int y = Integer.parseInt(pointY);
        if (x > DRAW_PANEL.getWidth() || y > DRAW_PANEL.getHeight()) {
            throw new IllegalArgumentException("Incorrect input data");
        }

        return new Point(x, y);
    }

    private String getInputDataFromTextField(JTextField field) {
        return field.getText();
    }
}
