package com.company;

import com.company.Listeners.ButtonDraggedListener;
import com.company.Listeners.MyButtonClickedListener;
import com.company.Listeners.MyKeyListener;
import com.company.Listeners.MyMouseMotionListener;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab06");
        frame.setMinimumSize(new Dimension(800, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);

        JButton button = new JButton("Button");
        button.setLocation(50,50);
        button.setSize(100,20);

        StatusBar statusBar = new StatusBar();
        statusBar.setLocation(0, frame.getSize().height - 100);

        MyMouseMotionListener listener = new MyMouseMotionListener(statusBar);
        panel.addMouseMotionListener(listener);

        ButtonDraggedListener listener2 = new ButtonDraggedListener(statusBar);
        button.addMouseMotionListener(listener2);

        MyButtonClickedListener listener1 = new MyButtonClickedListener(button);
        panel.addMouseListener(listener1);

        MyKeyListener listener3 = new MyKeyListener(button);
        button.addKeyListener(listener3);

        panel.add(button);
        panel.add(statusBar);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
