package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class View extends JFrame {
    public View(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CustomPanel customPanel = new CustomPanel();
        this.setContentPane(customPanel);
        this.setMinimumSize(new Dimension(800, 800));
        this.setVisible(true);
    }
}
