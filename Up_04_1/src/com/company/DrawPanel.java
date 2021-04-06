package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPanel extends JPanel {
    private static final int R = 100;
    private int seconds = 15;
    public DrawPanel(){
        super();
        Timer timer = new Timer(1000, new TimerListener(this));
        timer.start();
    }
    public void decreaseSeconds(){
        if (seconds == 0){
            seconds = 59;
        }else{
            this.seconds--;
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        int midX = this.getWidth() / 2;
        int midY = this.getHeight() / 2;
        g.drawLine(midX, midY, (int)(midX + R * Math.cos(2 * Math.PI / 60 * seconds)), (int)(midY - R * Math.sin(2 * Math.PI / 60 * seconds)));
        g.setColor(new Color(238, 238, 238));
        g.drawLine(midX, midY, (int)(midX + R * Math.cos(2 * Math.PI / 60 * (seconds + 1))), (int)(midY - R * Math.sin(2 * Math.PI / 60 * (seconds + 1))));
        g.setColor(Color.BLACK);
        g.drawOval(midX - R, midY - R, 2 * R, 2 * R);
    }
    private static class TimerListener implements ActionListener{
        private final DrawPanel drawPanel;
        public TimerListener(DrawPanel panel){
            this.drawPanel = panel;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            this.drawPanel.decreaseSeconds();
            this.drawPanel.repaint();
        }
    }
}
