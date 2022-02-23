package main.java.edu.bsu.shapes.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ColorValidator {

    private static final String COLOR_REGEXP = "0|[1-9][0-9]{0,2}";

    public static void validateColor(String color) {
        Pattern pattern = Pattern.compile(COLOR_REGEXP);
        Matcher matcher = pattern.matcher(color);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Incorrect value");
        }
    }

    private ColorValidator(){}
}
