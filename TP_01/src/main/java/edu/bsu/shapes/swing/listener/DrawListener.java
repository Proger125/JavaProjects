package main.java.edu.bsu.shapes.swing.listener;

import main.java.edu.bsu.shapes.entity.*;
import main.java.edu.bsu.shapes.entity.Polygon;
import main.java.edu.bsu.shapes.entity.Rectangle;
import main.java.edu.bsu.shapes.swing.config.DrawConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.edu.bsu.shapes.swing.config.AllItems.*;
import static main.java.edu.bsu.shapes.validator.IntegerValidator.validateInt;

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
                case ELLIPSE:
                    Ellipse ellipse = createEllipseFromInputData();
                    ellipse.setBorderColor(DrawConfig.getBorderColor());
                    ellipse.setFillColor(DrawConfig.getFillColor());
                    ellipse.draw(graphics);
                    break;
                case POLYGON:
                    Polygon polygon = createPolygonFromInputData();
                    polygon.setBorderColor(DrawConfig.getBorderColor());
                    polygon.setFillColor(DrawConfig.getFillColor());
                    polygon.draw(graphics);
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

    private Ellipse createEllipseFromInputData() {
        Point center = createPointFromTextFields(CENTER_POINT_X_FIELD, CENTER_POINT_Y_FIELD);
        int verticalRadius = createIntegerFromTextField(VERTICAL_RADIUS_FIELD);
        int horizontalRadius = createIntegerFromTextField(HORIZONTAL_RADIUS_FIELD);

        validateRadius(horizontalRadius, verticalRadius, center);

        return new Ellipse(center, verticalRadius, horizontalRadius);
    }

    private Polygon createPolygonFromInputData() {
        Point center = createPointFromTextFields(CENTER_POINT_X_FIELD, CENTER_POINT_Y_FIELD);
        int radius = createIntegerFromTextField(RADIUS_FIELD);
        int angleAmount = createIntegerFromTextField(ANGLE_AMOUNT_FIELD);

        validateRadius(radius, radius, center);

        return new Polygon(center, radius, angleAmount);
    }

    private Point createPointFromTextFields(JTextField pointXField, JTextField pointYField) {
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

    private int createIntegerFromTextField(JTextField textField) {
        String radius = textField.getText();

        validateInt(radius);

        return Integer.parseInt(radius);
    }

    private void validateRadius(int horizontalRadius, int verticalRadius, Point center) {
        if (center.x - horizontalRadius < 0
                || center.x + horizontalRadius > DRAW_PANEL.getWidth()
                || center.y - verticalRadius < 0
                || center.y + verticalRadius > DRAW_PANEL.getHeight()) {
            throw new IllegalArgumentException("Incorrect input data");
        }
    }
}
