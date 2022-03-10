package main.java.edu.bsu.figures.util;

import javax.swing.*;

import static main.java.edu.bsu.figures.validator.IntegerValidator.validateInt;

public final class IntegerCreator {

    public static int createInteger(JTextField textField) {
        String radius = textField.getText();

        validateInt(radius);

        return Integer.parseInt(radius);
    }

    private IntegerCreator() {}
}
