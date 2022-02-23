package main.java.edu.bsu.shapes.swing.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.java.edu.bsu.shapes.swing.config.AllItems.DRAW_PANEL;

public class CleanDrawPanelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DRAW_PANEL.repaint();
    }
}
