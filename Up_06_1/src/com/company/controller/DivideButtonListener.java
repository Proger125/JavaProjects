package com.company.controller;

import com.company.model.ImageModel;
import com.company.model.PointPair;
import com.company.view.panel.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class DivideButtonListener extends MouseAdapter {
    private ImageModel model;
    private MainPanel panel;
    public DivideButtonListener(ImageModel model, MainPanel panel){
        this.model = model;
        this.panel = panel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        BufferedImage image = model.getMainBufferedImage();
        int widthStep = image.getWidth() / panel.getHORIZONTAL_AMOUNT();
        int heightStep = image.getHeight() / panel.getVERTICAL_AMOUNT();
        HashMap<JPanel, PointPair> map = new HashMap<>();
        JPanel[] panels = panel.getDividedImagePanels();
        int xPosition = 0;
        for (int i = 0; i < panel.getHORIZONTAL_AMOUNT(); i++){
            int yPosition = 0;
            for (int j = 0; j < panel.getVERTICAL_AMOUNT(); j++){
                BufferedImage subImage = image.getSubimage(xPosition, yPosition, widthStep, heightStep);
                ImageIcon subImageIcon = new ImageIcon(subImage);
                JLabel label = new JLabel();
                label.setIcon(subImageIcon);
                label.setSize(panels[panel.getVERTICAL_AMOUNT() * i + j].getWidth(), panels[panel.getVERTICAL_AMOUNT() * i + j].getHeight());
                label.setLocation(0,0);
                panels[panel.getVERTICAL_AMOUNT() * i + j].removeAll();
                panels[panel.getVERTICAL_AMOUNT() * i + j].add(label);
                panels[panel.getVERTICAL_AMOUNT() * i + j].repaint();
                map.put(panels[panel.getVERTICAL_AMOUNT() * i + j], new PointPair(new Point(panels[panel.getVERTICAL_AMOUNT() * i + j].getX(), panels[panel.getVERTICAL_AMOUNT() * i + j].getY()), new Point(xPosition,yPosition)));
                yPosition += heightStep;
            }
            xPosition += widthStep;
        }
        panel.setDividedImagePanels(panels);
        model.setMap(map, panel);

    }
}
