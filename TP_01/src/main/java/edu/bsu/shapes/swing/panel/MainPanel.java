package main.java.edu.bsu.shapes.swing.panel;

import javax.swing.*;
import java.awt.*;

import static main.java.edu.bsu.shapes.swing.config.AllItems.*;

public class MainPanel extends JPanel {

    public MainPanel() {
        this.setLayout(new BorderLayout());
        this.add(OPTIONS_PANEL, BorderLayout.NORTH);
        this.add(LIST_PANEL, BorderLayout.WEST);
        this.add(DRAW_PANEL, BorderLayout.CENTER);
        this.add(BUTTON_PANEL, BorderLayout.SOUTH);
    }
}
