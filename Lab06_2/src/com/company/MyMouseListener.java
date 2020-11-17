package com.company;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
    private JButton button1;

    public MyMouseListener(JButton button1_){
        button1 = button1_;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == button1){
            JOptionPane.showMessageDialog(null, "Везёт вам", "Ответ", JOptionPane.PLAIN_MESSAGE);
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
