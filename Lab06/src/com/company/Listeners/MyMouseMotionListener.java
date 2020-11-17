package com.company.Listeners;

import com.company.StatusBar;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyMouseMotionListener implements MouseMotionListener {
    private StatusBar statusBar;
    public MyMouseMotionListener(StatusBar statusBar){
        this.statusBar = statusBar;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        this.statusBar.setMessage("Current mouse position " + e.getX() + " x " + e.getY() + " y");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.statusBar.setMessage("Current mouse position " + e.getX() + " x " + e.getY() + " y");
    }
}
