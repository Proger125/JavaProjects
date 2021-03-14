package com.company;

import javax.swing.*;

public class View extends JFrame {
    public View(String title, Model model){
        super(title);
        CustomPanel mainPanel = new CustomPanel(this, model);
        this.setContentPane(mainPanel);
        this.setSize(mainPanel.getWidth() + 14,  mainPanel.getHeight() + 37);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
