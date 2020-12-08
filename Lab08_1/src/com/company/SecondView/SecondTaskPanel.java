package com.company.SecondView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SecondTaskPanel extends JPanel {

    public SecondTaskPanel(LayoutManager manager){
        super(manager);
        GridLayout layout = (GridLayout)manager;
        ButtonClickListener listener = new ButtonClickListener();
        for (int i = 0; i < layout.getRows(); i++){
            for (int j = 0; j < layout.getColumns(); j++){
                JButton button = new JButton("Кнопка " + (i + j));
                button.setBackground(Color.CYAN);
                button.addMouseListener(listener);
                this.add(button);
            }
        }
    }
    private class ButtonClickListener extends MouseAdapter{
        private String previousName;
        @Override
        public void mouseReleased(MouseEvent e) {
            JButton button = (JButton)e.getSource();
            button.setText(previousName);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            JButton button = (JButton)e.getSource();
            previousName = button.getText();
            button.setText("Clicked");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton button = (JButton)e.getSource();
            button.setBackground(Color.MAGENTA);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton button = (JButton)e.getSource();
            button.setBackground(Color.CYAN);
        }
    }
}
