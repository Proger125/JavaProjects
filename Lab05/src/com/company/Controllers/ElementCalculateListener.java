package com.company.Controllers;

import com.company.Series.Series;
import com.company.View;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ElementCalculateListener implements MouseListener {
    private Series series;
    private View view;
    public ElementCalculateListener(Series series, View view){
        this.series = series;
        this.view = view;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        view.getElementField().setBackground(Color.WHITE);
        String text = view.getElementField().getText();
        int jElement = 0;
        try {
            jElement = Integer.parseInt(text);
        }catch(NumberFormatException exception){
            view.getElementField().setBackground(Color.RED);
        }
        if (view.getElementField().getBackground() != Color.RED) {
            double element = series.calculateJElement(jElement);
            view.getOutputElementLabel().setText(Double.toString(element));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
