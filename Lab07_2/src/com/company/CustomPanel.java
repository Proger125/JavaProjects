package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class CustomPanel extends JPanel {
    private BufferedImage bufferedImage;
    public CustomPanel(){
        super(null);
        bufferedImage = new BufferedImage(400, 600, 1);
        this.addMouseMotionListener(new CustomPanelMotionListener());
    }
    public void paintComponent(Graphics g){
        g.drawImage(bufferedImage, 0, 0, null);
    }
    private class CustomPanelMotionListener implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            Graphics g = bufferedImage.getGraphics();
            g.setColor(Color.RED);
            g.drawOval(e.getX(), e.getY(), 5, 5);
            //repaint();
            Graphics g1 = getGraphics();
            g1.setColor(Color.RED);
            g1.drawOval(e.getX(), e.getY(), 5, 5);
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
