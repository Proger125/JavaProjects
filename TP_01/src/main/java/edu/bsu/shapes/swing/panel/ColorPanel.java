package main.java.edu.bsu.shapes.swing.panel;

import javax.swing.*;
import java.awt.*;

import static main.java.edu.bsu.shapes.swing.config.AllItems.*;

public class ColorPanel extends JPanel {

    public ColorPanel() {
        this.setLayout(new GridLayout(2,5));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(BORDER_COLOR_BUTTON);
        BORDER_COLOR_BUTTON.setSelected(true);
        buttonGroup.add(FILL_COLOR_BUTTON);

        this.add(BORDER_COLOR_BUTTON);
        this.add(RED_COLOR_LABEL);
        this.add(GREEN_COLOR_LABEL);
        this.add(BLUE_COLOR_LABEL);
        this.add(new JPanel());
        this.add(FILL_COLOR_BUTTON);
        this.add(RED_COLOR_FIELD);
        this.add(GREEN_COLOR_FIELD);
        this.add(BLUE_COLOR_FIELD);
        this.add(PALETTE_PANEL);
    }
}
