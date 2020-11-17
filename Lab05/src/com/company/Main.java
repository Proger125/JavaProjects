package com.company;

import com.company.Controllers.SaveToFileListener;
import com.company.Series.LinearSeries;
import com.company.Series.Series;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, IllegalArgumentException {
        Series series = new LinearSeries();
        JFrame frame = new View("Test", series);
    }
}
