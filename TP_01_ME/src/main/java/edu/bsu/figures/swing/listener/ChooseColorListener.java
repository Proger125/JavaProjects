package main.java.edu.bsu.figures.swing.listener;

import main.java.edu.bsu.figures.swing.config.DrawConfig;
import main.java.edu.bsu.figures.swing.config.GraphicTitle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseColorListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        Color color = JColorChooser.showDialog(null, "Выберите цвет", Color.BLACK);
        if (button.getText().equals(GraphicTitle.BORDER_COLOR_BUTTON_NAME)) {
            DrawConfig.setBorderColor(color);
        } else {
            DrawConfig.setFillColor(color);
        }
        button.setBackground(color);
    }
}
