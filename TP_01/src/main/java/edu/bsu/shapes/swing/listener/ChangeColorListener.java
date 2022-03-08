package main.java.edu.bsu.shapes.swing.listener;

import main.java.edu.bsu.shapes.swing.config.DrawConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.edu.bsu.shapes.swing.config.AllItems.*;
import static main.java.edu.bsu.shapes.validator.ColorValidator.validateColor;

public class ChangeColorListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String redValue = RED_COLOR_FIELD.getText();
        String greenValue = GREEN_COLOR_FIELD.getText();
        String blueValue = BLUE_COLOR_FIELD.getText();

        try {
            int red = getIntColor(redValue);
            int green = getIntColor(greenValue);
            int blue = getIntColor(blueValue);
            Color color = new Color(red, green, blue);
            PALETTE_PANEL.setBackground(color);
            if (BORDER_COLOR_BUTTON.isSelected()) {
                DrawConfig.setBorderColor(color);
            } else {
                DrawConfig.setFillColor(color);
            }
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(null, "Incorrect input data");
        }


    }

    private int getIntColor(String value) {
        validateColor(value);
        return Integer.parseInt(value);
    }
}
