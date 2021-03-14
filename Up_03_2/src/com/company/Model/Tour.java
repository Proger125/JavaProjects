package com.company.Model;


import javax.swing.*;

public class Tour {
    private ImageIcon flag;
    private String description;
    private Double price;
    private Boolean isSelected;

    public Tour(ImageIcon flag, String description, Double price, Boolean isSelected) {
        this.flag = flag;
        this.description = description;
        this.price = price;
        this.isSelected = isSelected;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public ImageIcon getFlag() {
        return flag;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public void setFlag(ImageIcon flag) {
        this.flag = flag;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}
