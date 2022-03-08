package main.java.edu.bsu.shapes.swing.listener;

import main.java.edu.bsu.shapes.entity.Line;
import main.java.edu.bsu.shapes.entity.Ray;
import main.java.edu.bsu.shapes.entity.Rectangle;
import main.java.edu.bsu.shapes.entity.Segment;
import main.java.edu.bsu.shapes.entity.Triangle;
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
        try{
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
                case TRIANGLE:
                    Triangle triangle = createTriangleFromInputData();
                    triangle.setBorderColor(DrawConfig.getBorderColor());
                    triangle.setFillColor(DrawConfig.getFillColor());
                    triangle.draw(graphics);
                    break;
                case RECTANGLE:
                    Rectangle rectangle = createRectangleFromInputData();
                    rectangle.setBorderColor(DrawConfig.getBorderColor());
                    rectangle.setFillColor(DrawConfig.getFillColor());
                    rectangle.draw(graphics);
                    break;
            }
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(null, "Incorrect input data");
        }

        DRAW_PANEL.invalidate();
        DRAW_PANEL.validate();
    }

    private Ray createRayFromInputData() {
        Point firstPoint = createPointFromTextFields(FIRST_POINT_X_FIELD, FIRST_POINT_Y_FIELD);
        Point secondPoint = createPointFromTextFields(SECOND_POINT_X_FIELD, SECOND_POINT_Y_FIELD);
        return new Ray(firstPoint, secondPoint);
    }

    private Segment createSegmentFromInputData() {
        Point firstPoint = createPointFromTextFields(FIRST_POINT_X_FIELD, FIRST_POINT_Y_FIELD);
        Point secondPoint = createPointFromTextFields(SECOND_POINT_X_FIELD, SECOND_POINT_Y_FIELD);
        return new Segment(firstPoint, secondPoint);
    }

    private Line createLineFromInputData() {
        Point firstPoint = createPointFromTextFields(FIRST_POINT_X_FIELD, FIRST_POINT_Y_FIELD);
        Point secondPoint = createPointFromTextFields(SECOND_POINT_X_FIELD, SECOND_POINT_Y_FIELD);
        return new Line(firstPoint, secondPoint);
    }

    private Triangle createTriangleFromInputData() {
        Point pointA = createPointFromTextFields(FIRST_POINT_X_FIELD, FIRST_POINT_Y_FIELD);
        Point pointB = createPointFromTextFields(SECOND_POINT_X_FIELD, SECOND_POINT_Y_FIELD);
        Point pointC = createPointFromTextFields(THIRD_POINT_X_FIELD, THIRD_POINT_Y_FIELD);
        return new Triangle(pointA, pointB, pointC);
    }

    private Rectangle createRectangleFromInputData() {
        Point pointA = createPointFromTextFields(FIRST_POINT_X_FIELD, FIRST_POINT_Y_FIELD);
        Point pointB = createPointFromTextFields(SECOND_POINT_X_FIELD, SECOND_POINT_Y_FIELD);
        Point pointC = createPointFromTextFields(THIRD_POINT_X_FIELD, THIRD_POINT_Y_FIELD);
        Point pointD = createPointFromTextFields(FOURTH_POINT_X_FIELD, FOURTH_POINT_Y_FIELD);
        return new Rectangle(pointA, pointB, pointC, pointD);
    }

    private Point createPointFromTextFields(JTextField pointXField, JTextField pointYField) {
        String pointX = pointXField.getText();
        String pointY = pointYField.getText();

        validateCoordinate(pointX);
        validateCoordinate(pointY);

        int x = Integer.parseInt(pointX);
        int y = Integer.parseInt(pointY);
        if (x > DRAW_PANEL.getWidth() || y > DRAW_PANEL.getHeight()) {
            throw new IllegalArgumentException("Incorrect input data");
        }

        return new Point(x, y);
    }
}
