package main.java.edu.bsu.shapes.swing.panel;

import javax.swing.*;
import java.awt.*;

import static main.java.edu.bsu.shapes.swing.config.AllItems.*;

public class ButtonPanel extends JPanel {

    public ButtonPanel() {
        this.setLayout(new GridLayout(5, 1));
        this.add(DRAW_BUTTON);
        this.add(new JPanel());
        this.add(COLOR_PANEL);
        this.add(new JPanel());
        this.add(CLEAN_BUTTON);
    }
}
