package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {

    private BufferedImage bufferedImage;
    public BufferedImage getBufferedImage(){
        return bufferedImage;
    }
    private final MouseDrawListener listener = new MouseDrawListener(Color.RED);
    private final View view;
    public DrawPanel(View view){
        super(null);
        this.view = view;
        this.setPreferredSize(new Dimension(500, 500));
        bufferedImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
        this.addMouseMotionListener(listener);
    }

    public void paintComponent(Graphics g){
        g.drawImage(bufferedImage, 0, 0, null);
    }

    public void insertImage(Image image){
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.setPreferredSize(new Dimension(width, height));
        view.getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        view.getScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Graphics g = bufferedImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        Graphics g1 = this.getGraphics();
        g1.drawImage(image, 0, 0, null);
    }

    public void changeColor(Color color){
        listener.changeColor(color);
    }

    private class MouseDrawListener implements MouseMotionListener {
        private static final int  FIGURE_WIDTH = 5;
        private static final int FIGURE_HEIGHT = 5;
        Color color;
        public void changeColor(Color color){
            this.color = color;
        }
        public MouseDrawListener(Color color){
            this.color = color;
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            JPanel panel = (JPanel) e.getSource();
            Graphics g = panel.getGraphics();
            Graphics g1 = bufferedImage.getGraphics();
            int oldX = e.getX();
            int oldY = e.getY();
            g1.setColor(color);
            g1.drawRect(oldX, oldY, FIGURE_WIDTH, FIGURE_HEIGHT);
            g1.fillRect(oldX, oldY, FIGURE_WIDTH, FIGURE_HEIGHT);
            g.setColor(color);
            g.drawRect(oldX, oldY, FIGURE_WIDTH, FIGURE_HEIGHT);
            g.fillRect(oldX, oldY, FIGURE_WIDTH, FIGURE_HEIGHT);
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
