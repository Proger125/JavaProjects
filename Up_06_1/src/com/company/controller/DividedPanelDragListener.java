package com.company.controller;

import com.company.model.ImageModel;
import com.company.model.PointPair;
import com.company.view.panel.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class DividedPanelDragListener extends MouseAdapter {
    private JPanel emptyPanel;
    private ImageModel model;
    private MainPanel mainPanel;
    private final int EPS = 50;
    public DividedPanelDragListener(JPanel emptyPanel, ImageModel model, MainPanel mainPanel){
        this.emptyPanel = emptyPanel;
        this.model = model;
        this.mainPanel = mainPanel;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        mainPanel.moveToFront(panel);
        int parentX = panel.getLocation().x;
        int parentY = panel.getLocation().y;
        int x = e.getX();
        int y = e.getY();

        HashMap<JPanel, PointPair> map = model.getMap();
        PointPair pair = map.get(panel);
        Point correctPosition = new Point(pair.getCorrectPoint());
        correctPosition.x += emptyPanel.getX();
        correctPosition.y += emptyPanel.getY();
        if (correctPosition.x == pair.getCurrentPoint().x && correctPosition.y == pair.getCurrentPoint().y){
            panel.setLocation(pair.getCurrentPoint());
        }else{
            Point currentPosition = new Point(parentX + x, parentY + y);
            if (currentPosition.x < correctPosition.x + EPS && currentPosition.x > correctPosition.x - EPS
                    && currentPosition.y < correctPosition.y + EPS && currentPosition.y > correctPosition.y - EPS){
                panel.setLocation(correctPosition);
                model.addCorrectImages();
                if (model.getCorrectImages() == model.getCorrectImagesAmount()){
                    JOptionPane.showMessageDialog(null, "Паззл собран");
                    mainPanel.dividedPanelsAccommodation();
                    mainPanel.repaint();
                }
                pair.setCurrentPoint(correctPosition);
            }else{
                panel.setLocation(parentX + x, parentY + y);
            }
        }

    }
}
