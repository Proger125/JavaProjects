package com.company.Listeners;

import com.company.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColorItemsListener implements ItemListener {
    private View view;
    public ColorItemsListener(View view){
        this.view = view;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        JRadioButton button = (JRadioButton) e.getSource();
        if (button == view.getRedColorButton()){
            view.changeColor(Color.RED);
        }else if(button == view.getGreenColorButton()){
            view.changeColor(Color.GREEN);
        }else if (button == view.getBlueColorButton()){
            view.changeColor(Color.BLUE);
        }
    }
}
