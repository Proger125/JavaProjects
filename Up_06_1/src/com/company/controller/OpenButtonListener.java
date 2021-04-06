package com.company.controller;

import com.company.model.ImageModel;
import com.company.view.panel.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class OpenButtonListener extends MouseAdapter {
    private final ImageModel model;
    private final MainPanel panel;
    public OpenButtonListener(ImageModel model, MainPanel panel){
        this.model = model;
        this.panel = panel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser chooser = new JFileChooser();
        int res = chooser.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION){
            File targetFile = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(new ImageIcon(targetFile.getPath()).getImage().getScaledInstance(357, 426, Image.SCALE_DEFAULT));
            model.setMainIcon(icon);
            model.setCorrectImages(0);
            JPanel imagePanel = panel.getFilledImagePanel();
            imagePanel.removeAll();
            JLabel label = new JLabel();
            label.setIcon(icon);
            label.setSize(imagePanel.getSize());
            label.setLocation(0,0);
            imagePanel.add(label);
            imagePanel.repaint();
        }
    }
}
