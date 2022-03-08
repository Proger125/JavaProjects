package main.java.edu.bsu.shapes.swing.listener;

import main.java.edu.bsu.shapes.swing.config.DrawConfig;
import main.java.edu.bsu.shapes.swing.config.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.edu.bsu.shapes.swing.config.AllItems.*;
import static main.java.edu.bsu.shapes.swing.config.ButtonName.LINE_BUTTON;
import static main.java.edu.bsu.shapes.swing.config.ButtonName.RAY_BUTTON;
import static main.java.edu.bsu.shapes.swing.config.ButtonName.SEGMENT_BUTTON;
import static main.java.edu.bsu.shapes.swing.config.ButtonName.TRIANGLE_BUTTON;
import static main.java.edu.bsu.shapes.swing.config.ButtonName.RECTANGLE_BUTTON;

public class SelectListItemListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        OPTIONS_PANEL.removeAll();
        JRadioButton radioButton = (JRadioButton) e.getSource();
        String name = radioButton.getText();
        switch (name) {
            case LINE_BUTTON:
                createSegmentOptionsPanel();
                DrawConfig.setFigure(Figure.LINE);
                break;
            case RAY_BUTTON:
                createSegmentOptionsPanel();
                DrawConfig.setFigure(Figure.RAY);
                break;
            case SEGMENT_BUTTON:
                createSegmentOptionsPanel();
                DrawConfig.setFigure(Figure.SEGMENT);
                break;
            case TRIANGLE_BUTTON:
                createTriangleOptionsPanel();
                DrawConfig.setFigure(Figure.TRIANGLE);
                break;
            case RECTANGLE_BUTTON:
                createRectangleOptionsPanel();
                DrawConfig.setFigure(Figure.RECTANGLE);
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
}
