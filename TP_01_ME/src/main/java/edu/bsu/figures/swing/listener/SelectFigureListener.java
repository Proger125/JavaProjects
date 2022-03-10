package main.java.edu.bsu.figures.swing.listener;

import main.java.edu.bsu.figures.swing.config.DrawConfig;
import main.java.edu.bsu.figures.swing.config.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.edu.bsu.figures.swing.config.Graphic.*;
import static main.java.edu.bsu.figures.swing.config.GraphicTitle.*;

public class SelectFigureListener implements ActionListener {

    private static final int OPTIONS_FRAME_WIDTH = 700;
    private static final int OPTIONS_FRAME_HEIGHT = 500;
    @Override
    public void actionPerformed(ActionEvent e) {
        OPTIONS_FRAME.setSize(OPTIONS_FRAME_WIDTH, OPTIONS_FRAME_HEIGHT);
        OPTIONS_FRAME.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel mainOptionsPanel = new JPanel();
        mainOptionsPanel.setLayout(new BorderLayout());
        OPTIONS_PANEL.removeAll();
        mainOptionsPanel.add(OPTIONS_PANEL, BorderLayout.CENTER);
        JButton drawButton = new JButton(DRAW_BUTTON_NAME);
        mainOptionsPanel.add(drawButton, BorderLayout.SOUTH);

        OPTIONS_FRAME.setContentPane(mainOptionsPanel);

        JRadioButton radioButton = (JRadioButton) e.getSource();
        switch (radioButton.getText()) {
            case SEGMENT_BUTTON_NAME:
                DrawConfig.setFigure(Figure.SEGMENT);
                drawButton.addActionListener(DRAW_BY_TWO_POINTS_LISTENER);
                addPointsOptions(2);
                break;
            case RAY_BUTTON_NAME:
                DrawConfig.setFigure(Figure.RAY);
                drawButton.addActionListener(DRAW_BY_TWO_POINTS_LISTENER);
                addPointsOptions(2);
                break;
            case LINE_BUTTON_NAME:
                DrawConfig.setFigure(Figure.LINE);
                drawButton.addActionListener(DRAW_BY_TWO_POINTS_LISTENER);
                addPointsOptions(2);
                break;
            case POLYGON_BUTTON_NAME:
                DrawConfig.setFigure(Figure.POLYGON);
                String result = JOptionPane.showInputDialog(
                        null,
                        "Введите кол-во углов:",
                        "Опции",
                        JOptionPane.PLAIN_MESSAGE
                );
                try {
                    int points = Integer.parseInt(result);
                    addPointsOptions(points);
                    drawButton.addActionListener(DRAW_POLYGON_LISTENER);
                } catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Некорректное кол-во углов",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
                break;
            case REGULAR_POLYGON_BUTTON_NAME:
                DrawConfig.setFigure(Figure.REGULAR_POLYGON);
                addRegularPolygonOptions();
                drawButton.addActionListener(DRAW_REGULAR_POLYGON_LISTENER);
                break;
            case ELLIPSE_BUTTON_NAME:
                DrawConfig.setFigure(Figure.ELLIPSE);
                addEllipseOptions();
                drawButton.addActionListener(DRAW_ELLIPSE_LISTENER);
                break;
        }
        OPTIONS_FRAME.setVisible(true);
    }

    private void addPointsOptions(int points) {
        OPTIONS_PANEL.setLayout(new GridLayout(points, 4));
        POINTS_LABELS.clear();
        POINTS_FIELDS.clear();
        for (int i = 1; i <= points; i++) {
            JLabel xPointLabel = new JLabel("X координата " + i + " точки");
            POINTS_LABELS.add(xPointLabel);
            OPTIONS_PANEL.add(xPointLabel);
            JTextField xPointField = new JTextField();
            POINTS_FIELDS.add(xPointField);
            OPTIONS_PANEL.add(xPointField);
            JLabel yPointLabel = new JLabel("Y координата " + i + " точки");
            POINTS_LABELS.add(yPointLabel);
            OPTIONS_PANEL.add(yPointLabel);
            JTextField yPointField = new JTextField();
            POINTS_FIELDS.add(yPointField);
            OPTIONS_PANEL.add(yPointField);
        }
    }

    private void addRegularPolygonOptions() {
        OPTIONS_PANEL.setLayout(new GridLayout(2, 4));
        addCenterPointOptions();
        OPTIONS_PANEL.add(RADIUS_LABEL);
        OPTIONS_PANEL.add(RADIUS_FIELD);
        OPTIONS_PANEL.add(ANGLES_AMOUNT_LABEL);
        OPTIONS_PANEL.add(ANGLES_AMOUNT_FIELD);
    }

    private void addEllipseOptions() {
        OPTIONS_PANEL.setLayout(new GridLayout(2, 4));
        addCenterPointOptions();
        OPTIONS_PANEL.add(HORIZONTAL_RADIUS_LABEL);
        OPTIONS_PANEL.add(HORIZONTAL_RADIUS_FIELD);
        OPTIONS_PANEL.add(VERTICAL_RADIUS_LABEL);
        OPTIONS_PANEL.add(VERTICAL_RADIUS_FIELD);
    }

    private void addCenterPointOptions() {
        OPTIONS_PANEL.add(CENTER_POINT_X_LABEL);
        OPTIONS_PANEL.add(CENTER_POINT_X_FIELD);
        OPTIONS_PANEL.add(CENTER_POINT_Y_LABEL);
        OPTIONS_PANEL.add(CENTER_POINT_Y_FIELD);
    }
}
