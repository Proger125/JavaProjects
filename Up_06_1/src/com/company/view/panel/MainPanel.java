package com.company.view.panel;

import com.company.controller.DividedPanelDragListener;
import com.company.model.ImageModel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JLayeredPane {
    private final ImageModel model;
    private final JPanel filledImagePanel;
    private final JPanel emptyImagePanel;
    public static final int IMAGE_PANEL_WIDTH = 357;
    public static final int IMAGE_PANEL_HEIGHT = 426;
    private final int HORIZONTAL_AMOUNT = 4;
    private final int VERTICAL_AMOUNT = 2;
    private JPanel[] dividedImagePanels;

    public static int getImagePanelWidth() {
        return IMAGE_PANEL_WIDTH;
    }

    public static int getImagePanelHeight() {
        return IMAGE_PANEL_HEIGHT;
    }

    public int getHORIZONTAL_AMOUNT() {
        return HORIZONTAL_AMOUNT;
    }

    public int getVERTICAL_AMOUNT() {
        return VERTICAL_AMOUNT;
    }

    public MainPanel(ImageModel model){
        super();
        this.model = model;
        model.setCorrectImagesAmount(HORIZONTAL_AMOUNT * VERTICAL_AMOUNT);
        this.setLayout(null);
        filledImagePanel = new JPanel();
        filledImagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        filledImagePanel.setSize(IMAGE_PANEL_WIDTH, IMAGE_PANEL_HEIGHT);
        filledImagePanel.setLocation(10, 50);
        filledImagePanel.setLayout(null);
        this.add(filledImagePanel);
        //
        emptyImagePanel = new JPanel();
        emptyImagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        emptyImagePanel.setSize(IMAGE_PANEL_WIDTH, IMAGE_PANEL_HEIGHT);
        emptyImagePanel.setLocation(IMAGE_PANEL_WIDTH + 20, 50);
        this.add(emptyImagePanel);
        //
        int size = HORIZONTAL_AMOUNT * VERTICAL_AMOUNT;
        dividedImagePanels = new JPanel[size];
        for (int i = 0; i < HORIZONTAL_AMOUNT; i++){
            for (int j = 0; j < VERTICAL_AMOUNT; j++){
                dividedImagePanels[VERTICAL_AMOUNT * i + j] = new JPanel();
                dividedImagePanels[VERTICAL_AMOUNT * i + j].setLayout(null);
                dividedImagePanels[VERTICAL_AMOUNT * i + j].addMouseMotionListener(new DividedPanelDragListener(emptyImagePanel, model, this));
                dividedImagePanels[VERTICAL_AMOUNT * i + j].setSize(IMAGE_PANEL_WIDTH / HORIZONTAL_AMOUNT, IMAGE_PANEL_HEIGHT / VERTICAL_AMOUNT);
                dividedImagePanels[VERTICAL_AMOUNT * i + j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        }
        dividedPanelsAccommodation();
        for (int i = 0; i < HORIZONTAL_AMOUNT; i++){
            for (int j = 0; j < VERTICAL_AMOUNT; j++){
                this.add(dividedImagePanels[VERTICAL_AMOUNT * i + j]);
            }
        }
    }
    public void dividedPanelsAccommodation(){
        int horizontalStep = IMAGE_PANEL_WIDTH / HORIZONTAL_AMOUNT;
        int verticalStep = IMAGE_PANEL_HEIGHT / VERTICAL_AMOUNT;
        for (int i = 0; i < HORIZONTAL_AMOUNT; i++){
            for (int j = 0; j < VERTICAL_AMOUNT; j++){
                dividedImagePanels[VERTICAL_AMOUNT * i + j].setLocation(2 * IMAGE_PANEL_WIDTH + 50 + horizontalStep * ((VERTICAL_AMOUNT * i + j) % 4), 10 + verticalStep * ((VERTICAL_AMOUNT * i + j) / 4));
            }
        }
    }
    public JPanel getEmptyImagePanel() {
        return emptyImagePanel;
    }

    public JPanel[] getDividedImagePanels() {
        return dividedImagePanels;
    }

    public JPanel getFilledImagePanel() {
        return filledImagePanel;
    }

    public void setDividedImagePanels(JPanel[] dividedImagePanels) {
        this.dividedImagePanels = dividedImagePanels;

    }
}
