package com.company.view;

import com.company.model.CustomModel;
import com.company.view.panel.CustomPanel;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private CustomPanel panel;
    private CustomModel model;
    public View(String title){
        super(title);
        model = new CustomModel(this);
        panel = new CustomPanel(model);
        this.setContentPane(panel);
        this.setSize(new Dimension(800, 500));
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public CustomPanel getPanel() {
        return panel;
    }
}
