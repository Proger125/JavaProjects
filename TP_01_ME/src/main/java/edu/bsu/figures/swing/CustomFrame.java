package main.java.edu.bsu.figures.swing;

import javax.swing.*;

import static main.java.edu.bsu.figures.swing.config.Graphic.MAIN_PANEL;

public class CustomFrame extends JFrame {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 600;

    private static final String TITLE = "Figures";

    public CustomFrame() {
        this.setTitle(TITLE);
        this.setSize(WIDTH, HEIGHT);
        this.setContentPane(MAIN_PANEL);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
