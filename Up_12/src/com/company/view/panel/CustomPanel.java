package com.company.view.panel;

import com.company.model.CustomModel;

import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    private final CustomModel model;
    private final JTable table;
    private final ButtonPanel buttonPanel;
    public CustomPanel(CustomModel model){
        this.model = model;
        this.setLayout(new BorderLayout());
        buttonPanel = new ButtonPanel(this.model);
        table = new JTable(model.getModel());
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);
    }
    public JTable getTable(){
        return table;
    }
}
