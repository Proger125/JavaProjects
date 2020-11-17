package com.company.Listeners;

import com.company.StatusBar;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ButtonDraggedListener implements MouseMotionListener {
    private StatusBar statusBar;
    public ButtonDraggedListener(StatusBar statusBar){
        this.statusBar = statusBar;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        int parentX = button.getLocation().x;
        int parentY = button.getLocation().y;
        int x = e.getX();
        int y = e.getY();
        if (e.isControlDown()){
            button.setLocation(parentX + x, parentY + y);

        }
        statusBar.setMessage("Current mouse position "+ (parentX + x) + " х "+ (parentY + y) + " y");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        int parentX = button.getLocation().x;
        int parentY = button.getLocation().y;
        this.statusBar.setMessage("Current mouse position " + (parentX + e.getX()) + " x " + (parentY + e.getY()) + " y");
    }
}
