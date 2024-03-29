package main.java.edu.bsu.shapes.swing.panel;

import javax.swing.*;
import java.awt.*;

import static main.java.edu.bsu.shapes.swing.config.AllItems.*;

public class ListPanel extends JPanel {

    public ListPanel() {
        this.setLayout(new GridLayout(7, 1));
        ButtonGroup listGroup = new ButtonGroup();

        listGroup.add(SEGMENT_BUTTON);
        this.add(SEGMENT_BUTTON);

        listGroup.add(RAY_BUTTON);
        this.add(RAY_BUTTON);

        listGroup.add(LINE_BUTTON);
        this.add(LINE_BUTTON);

        listGroup.add(TRIANGLE_BUTTON);
        this.add(TRIANGLE_BUTTON);

        listGroup.add(RECTANGLE_BUTTON);
        this.add(RECTANGLE_BUTTON);

        listGroup.add(ELLIPSE_BUTTON);
        this.add(ELLIPSE_BUTTON);

        listGroup.add(POLYGON_BUTTON);
        this.add(POLYGON_BUTTON);
    }
}
