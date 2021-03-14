package com.company;

import javax.swing.*;
import java.awt.*;

public class Model {
    private ImageIcon imageIcon;
    private Integer speed;
    private Direction direction;
    private Integer radius;
    private Double angle = Math.PI / 2;

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Double getAngularVelocity(){
        if (radius != 0){
            return (double)speed / (double)radius;
        }
        return 0.0;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
