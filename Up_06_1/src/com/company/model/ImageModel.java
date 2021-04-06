package com.company.model;

import com.company.view.panel.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class ImageModel {
    private ImageIcon mainIcon;
    private HashMap<JPanel, PointPair> map = new HashMap<>();
    private ImageIcon selectedImage;
    private boolean isImageUploaded = false;
    private boolean isImageDivided = false;
    private int correctImages = 0;
    private int correctImagesAmount = 0;

    public int getCorrectImagesAmount() {
        return correctImagesAmount;
    }

    public void setCorrectImagesAmount(int correctImagesAmount) {
        this.correctImagesAmount = correctImagesAmount;
    }

    public void setCorrectImages(int correctImages) {
        this.correctImages = correctImages;
    }

    public int getCorrectImages() {
        return correctImages;
    }

    public void addCorrectImages() {
        this.correctImages++;
    }

    public ImageIcon getSelectedImage() {
        return selectedImage;
    }

    public void setSelectedImage(ImageIcon selectedImage) {
        this.selectedImage = selectedImage;
    }

    public ImageIcon getMainIcon() {
        return mainIcon;
    }

    public HashMap<JPanel, PointPair> getMap() {
        return map;
    }

    public void setMap(HashMap<JPanel, PointPair> map, MainPanel panel) {
        this.map = map;
        this.isImageDivided = true;
        this.isImageUploaded = false;
    }

    public boolean isImageUploaded() {
        return isImageUploaded;
    }

    public boolean isImageDivided() {
        return isImageDivided;
    }

    public BufferedImage getMainBufferedImage(){
        BufferedImage image = new BufferedImage(mainIcon.getIconWidth(), mainIcon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        mainIcon.paintIcon(null, g, 0, 0);
        return image;
    }
    public void setMainIcon(ImageIcon mainIcon) {
        this.mainIcon = mainIcon;
        this.isImageUploaded = true;
    }
}
