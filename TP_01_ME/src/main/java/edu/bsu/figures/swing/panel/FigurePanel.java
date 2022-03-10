package main.java.edu.bsu.figures.swing.panel;

import javax.swing.*;
import java.awt.*;

import static main.java.edu.bsu.figures.swing.config.Graphic.*;

public class FigurePanel extends JPanel {

    private final ButtonGroup buttonGroup = new ButtonGroup();

    public FigurePanel() {
        this.setLayout(new GridLayout(1, 6));

        addButton(SEGMENT_BUTTON);
        addButton(RAY_BUTTON);
        addButton(LINE_BUTTON);
        addButton(POLYGON_BUTTON);
        addButton(REGULAR_POLYGON_BUTTON);
        addButton(ELLIPSE_BUTTON);
    }

    private void addButton(JRadioButton radioButton) {
        this.add(radioButton);
        buttonGroup.add(radioButton);
    }
}
