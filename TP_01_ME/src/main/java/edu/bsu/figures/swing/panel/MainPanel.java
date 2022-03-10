package main.java.edu.bsu.figures.swing.panel;

import javax.swing.*;
import java.awt.*;

import static main.java.edu.bsu.figures.swing.config.Graphic.*;

public class MainPanel extends JPanel {

    public MainPanel() {
        this.setLayout(new BorderLayout());
        this.add(FIGURE_PANEL, BorderLayout.NORTH);
        this.add(DRAW_PANEL, BorderLayout.CENTER);
        this.add(BUTTON_PANEL, BorderLayout.SOUTH);
    }
}
