package com.company.view;

import com.company.model.ImageModel;
import com.company.view.panel.ButtonsPanel;
import com.company.view.panel.MainPanel;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    public View(String title){
        super(title);
        JPanel panel = new JPanel(new BorderLayout());
        ImageModel imageModel = new ImageModel();
        MainPanel mainPanel = new MainPanel(imageModel);
        panel.add(mainPanel, BorderLayout.CENTER);
        panel.add(new ButtonsPanel(mainPanel, imageModel), BorderLayout.NORTH);
        this.setContentPane(panel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width,screenSize.height);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
