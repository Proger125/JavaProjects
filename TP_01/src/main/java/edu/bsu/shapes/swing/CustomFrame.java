package main.java.edu.bsu.shapes.swing;


import javax.swing.*;

import static main.java.edu.bsu.shapes.swing.config.AllItems.MAIN_PANEL;

public class CustomFrame extends JFrame {

    private static final int WIDTH = 1200;

    private static final int HEIGHT = 600;

    public CustomFrame(String title) {
        super(title);

        this.setSize(WIDTH, HEIGHT);
        this.setContentPane(MAIN_PANEL);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
