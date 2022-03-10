package main.java.edu.bsu.figures.swing.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.edu.bsu.figures.swing.config.Graphic.DRAW_PANEL;

public class CleanButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DRAW_PANEL.repaint();
    }
}
