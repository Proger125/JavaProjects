package main.java.edu.bsu.shapes.swing.listener;

import main.java.edu.bsu.shapes.swing.config.DrawConfig;
import main.java.edu.bsu.shapes.swing.config.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.edu.bsu.shapes.swing.config.AllItems.*;
import static main.java.edu.bsu.shapes.swing.config.ButtonName.LINE_BUTTON_NAME;
import static main.java.edu.bsu.shapes.swing.config.ButtonName.RAY_BUTTON_NAME;
import static main.java.edu.bsu.shapes.swing.config.ButtonName.SEGMENT_BUTTON_NAME;
import static main.java.edu.bsu.shapes.swing.config.ButtonName.TRIANGLE_BUTTON_NAME;
import static main.java.edu.bsu.shapes.swing.config.ButtonName.RECTANGLE_BUTTON_NAME;
import static main.java.edu.bsu.shapes.swing.config.ButtonName.ELLIPSE_BUTTON_NAME;
import static main.java.edu.bsu.shapes.swing.config.ButtonName.POLYGON_BUTTON_NAME;

public class SelectListItemListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        OPTIONS_PANEL.removeAll();
        JRadioButton radioButton = (JRadioButton) e.getSource();
        String name = radioButton.getText();
        switch (name) {
            case LINE_BUTTON_NAME:
                createSegmentOptionsPanel();
                DrawConfig.setFigure(Figure.LINE);
                break;
            case RAY_BUTTON_NAME:
                createSegmentOptionsPanel();
                DrawConfig.setFigure(Figure.RAY);
                break;
            case SEGMENT_BUTTON_NAME:
                createSegmentOptionsPanel();
                DrawConfig.setFigure(Figure.SEGMENT);
                break;
            case TRIANGLE_BUTTON_NAME:
                createTriangleOptionsPanel();
                DrawConfig.setFigure(Figure.TRIANGLE);
                break;
            case RECTANGLE_BUTTON_NAME:
                createRectangleOptionsPanel();
                DrawConfig.setFigure(Figure.RECTANGLE);
                break;
            case ELLIPSE_BUTTON_NAME:
                createEllipseOptionsPane();
                DrawConfig.setFigure(Figure.ELLIPSE);
                break;
            case POLYGON_BUTTON_NAME:
                createPolygonOptionPane();
                DrawConfig.setFigure(Figure.POLYGON);
                break;
        }
        DRAW_BUTTON.setEnabled(true);
        MAIN_PANEL.invalidate();
        MAIN_PANEL.validate();
    }

    private void createSegmentOptionsPanel() {
        OPTIONS_PANEL.setLayout(new GridLayout(2,4));
        addFirstPointOptions();
        addSecondPointOptions();
    }

    private void createTriangleOptionsPanel() {
        OPTIONS_PANEL.setLayout(new GridLayout(3, 4));
        addFirstPointOptions();
        addSecondPointOptions();
        addThirdPointOptions();
    }

    private void createRectangleOptionsPanel() {
        OPTIONS_PANEL.setLayout(new GridLayout(4, 4));
        addFirstPointOptions();
        addSecondPointOptions();
        addThirdPointOptions();
        addFourthPointOptions();
    }

    private void createEllipseOptionsPane() {
        OPTIONS_PANEL.setLayout(new GridLayout(2,4));
        addCenterPointOptions();
        addRadiusOptions();
    }

    private void createPolygonOptionPane() {
        OPTIONS_PANEL.setLayout(new GridLayout(2, 4));
        addCenterPointOptions();
        addOneRadiusAndAngleOptions();
    }

    private void addFirstPointOptions() {
        OPTIONS_PANEL.add(FIRST_POINT_X_LABEL);
        OPTIONS_PANEL.add(FIRST_POINT_X_FIELD);
        OPTIONS_PANEL.add(FIRST_POINT_Y_LABEL);
        OPTIONS_PANEL.add(FIRST_POINT_Y_FIELD);
    }

    private void addSecondPointOptions() {
        OPTIONS_PANEL.add(SECOND_POINT_X_LABEL);
        OPTIONS_PANEL.add(SECOND_POINT_X_FIELD);
        OPTIONS_PANEL.add(SECOND_POINT_Y_LABEL);
        OPTIONS_PANEL.add(SECOND_POINT_Y_FIELD);
    }

    private void addThirdPointOptions() {
        OPTIONS_PANEL.add(THIRD_POINT_X_LABEL);
        OPTIONS_PANEL.add(THIRD_POINT_X_FIELD);
        OPTIONS_PANEL.add(THIRD_POINT_Y_LABEL);
        OPTIONS_PANEL.add(THIRD_POINT_Y_FIELD);
    }

    private void addFourthPointOptions() {
        OPTIONS_PANEL.add(FOURTH_POINT_X_LABEL);
        OPTIONS_PANEL.add(FOURTH_POINT_X_FIELD);
        OPTIONS_PANEL.add(FOURTH_POINT_Y_LABEL);
        OPTIONS_PANEL.add(FOURTH_POINT_Y_FIELD);
    }

    private void addCenterPointOptions() {
        OPTIONS_PANEL.add(CENTER_POINT_X_LABEL);
        OPTIONS_PANEL.add(CENTER_POINT_X_FIELD);
        OPTIONS_PANEL.add(CENTER_POINT_Y_LABEL);
        OPTIONS_PANEL.add(CENTER_POINT_Y_FIELD);
    }

    private void addOneRadiusAndAngleOptions() {
        OPTIONS_PANEL.add(RADIUS_LABEL);
        OPTIONS_PANEL.add(RADIUS_FIELD);
        OPTIONS_PANEL.add(ANGLE_AMOUNT_LABEL);
        OPTIONS_PANEL.add(ANGLE_AMOUNT_FIELD);
    }

    private void addRadiusOptions() {
        OPTIONS_PANEL.add(HORIZONTAL_RADIUS_LABEL);
        OPTIONS_PANEL.add(HORIZONTAL_RADIUS_FIELD);
        OPTIONS_PANEL.add(VERTICAL_RADIUS_LABEL);
        OPTIONS_PANEL.add(VERTICAL_RADIUS_FIELD);
    }
}
