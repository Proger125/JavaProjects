package edu.bsu.shop.view;

import edu.bsu.shop.view.config.GraphicalItems;

import javax.swing.*;

public class CustomFrame extends JFrame {
    public CustomFrame(String title) {
        super(title);

        this.setSize(800, 400);
        this.setContentPane(GraphicalItems.LOGIN_PANEL);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
