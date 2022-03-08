package main.java.edu.bsu.shapes.swing.listener;

import main.java.edu.bsu.shapes.swing.config.ButtonName;
import main.java.edu.bsu.shapes.swing.config.DrawConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.edu.bsu.shapes.swing.config.AllItems.*;

public class ChangeColorStateListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton radioButton = (JRadioButton) e.getSource();
        Color color;
        if (radioButton.getText().equals(ButtonName.FILL_COLOR_BUTTON)) {
            color = DrawConfig.getFillColor();
        } else {
            color = DrawConfig.getBorderColor();
        }
        RED_COLOR_FIELD.setText(Integer.toString(color.getRed()));
        GREEN_COLOR_FIELD.setText(Integer.toString(color.getGreen()));
        BLUE_COLOR_FIELD.setText(Integer.toString(color.getBlue()));
        PALETTE_PANEL.setBackground(color);
    }
}
