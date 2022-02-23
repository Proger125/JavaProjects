package main.java.edu.bsu.shapes.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CoordinateValidator {

    private static final String INTEGER_REGEXP = "0|[1-9][0-9]{0,2}";

    public static void validateCoordinate(String value) {
        Pattern pattern = Pattern.compile(INTEGER_REGEXP);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Incorrect value");
        }
    }

    private CoordinateValidator() {}
}
