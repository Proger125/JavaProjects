package com.company;

import javax.swing.*;

public class View extends JFrame {

    public View(String title){
        super(title);
        DrawPanel mainPanel = new DrawPanel();
        this.setContentPane(mainPanel);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
