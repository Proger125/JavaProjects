package com.company.view.panel;

import com.company.Main;
import com.company.controller.DivideButtonListener;
import com.company.controller.OpenButtonListener;
import com.company.model.ImageModel;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    JButton openImageButton = new JButton("Открыть");
    JButton divideImageButton = new JButton("Разделить");
    MainPanel panel;
    ImageModel model;
    public ButtonsPanel(MainPanel panel, ImageModel model){
        super();
        this.model = model;
        this.panel = panel;
        this.setLayout(new GridLayout());
        openImageButton.addMouseListener(new OpenButtonListener(model, panel));
        divideImageButton.addMouseListener(new DivideButtonListener(model, panel));
        this.add(openImageButton);
        this.add(divideImageButton);
    }
}
