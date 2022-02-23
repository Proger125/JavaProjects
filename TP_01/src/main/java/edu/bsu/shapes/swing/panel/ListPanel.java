package main.java.edu.bsu.shapes.swing.panel;

import javax.swing.*;
import java.awt.*;

import static main.java.edu.bsu.shapes.swing.config.AllItems.*;

public class ListPanel extends JPanel {

    public ListPanel() {
        this.setLayout(new GridLayout(3, 1));
        ButtonGroup listGroup = new ButtonGroup();

        listGroup.add(SEGMENT_BUTTON);
        this.add(SEGMENT_BUTTON);

        listGroup.add(RAY_BUTTON);
        this.add(RAY_BUTTON);

        listGroup.add(LINE_BUTTON);
        this.add(LINE_BUTTON);
    }
}
