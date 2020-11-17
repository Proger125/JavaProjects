package com.company.Listeners;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    private JButton button_;
    public MyKeyListener(JButton button){
        this.button_ = button;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
            StringBuilder builder = new StringBuilder(button_.getText());
            if (builder.length() > 0){
                builder.deleteCharAt(builder.length() - 1);
            }
            button_.setText(builder.toString());
        }
        else if ((e.getKeyChar() >= '!' && e.getKeyChar() <= '~') || (e.getKeyChar() >= 'А' && e.getKeyChar() <= 'я')){
            StringBuilder builder = new StringBuilder(button_.getText());
            builder.append(e.getKeyChar());
            button_.setText(builder.toString());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
