package main.java.edu.bsu.figures.swing.panel;

import javax.swing.*;
import java.awt.*;

import static main.java.edu.bsu.figures.swing.config.Graphic.*;

public class ButtonPanel extends JPanel {

    public ButtonPanel() {
        this.setLayout(new GridLayout(1, 3));

        this.add(CHOOSE_BORDER_COLOR_BUTTON);
        this.add(CHOOSE_FILL_COLOR_BUTTON);
        this.add(CLEAN_ALL_BUTTON);
    }
}
