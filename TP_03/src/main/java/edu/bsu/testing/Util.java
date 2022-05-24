package edu.bsu.testing;

public class Util {

    public static int max(int ... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }
}
