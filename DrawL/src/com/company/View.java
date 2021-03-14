package com.company;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    public View(String title){
        super(title);
        this.setSize(500, 500);
        CustomPanel panel = new CustomPanel();
        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
