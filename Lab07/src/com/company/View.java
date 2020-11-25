package com.company;

import com.company.Listeners.ColorItemsListener;
import com.company.Listeners.FileManipulationsListener;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private final JRadioButton redColorButton = new JRadioButton("Red");
    private final JRadioButton greenColorButton = new JRadioButton("Green");
    private final JRadioButton blueColorButton = new JRadioButton("Blue");
    private final DrawPanel drawPanel = new DrawPanel(this);
    private final JScrollPane scrollPane = new JScrollPane(drawPanel);
    public JRadioButton getRedColorButton(){
        return redColorButton;
    }
    public JRadioButton getGreenColorButton(){
        return greenColorButton;
    }
    public JRadioButton getBlueColorButton(){
        return blueColorButton;
    }
    public DrawPanel getDrawPanel(){
        return drawPanel;
    }
    public JScrollPane getScrollPane(){return scrollPane;}
    public View(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800, 800));
        this.setResizable(false);
        this.addComponents();
        this.setVisible(true);
    }
    private void addComponents(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        drawPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
        drawPanel.setPreferredSize(new Dimension(600, 600));
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new GridLayout(1,3));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Colors"));
        addButtons(buttonPanel);
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        this.add(mainPanel);
    }
    private void addButtons(JPanel buttonPanel){
        ButtonGroup group = new ButtonGroup();
        group.add(redColorButton);
        ColorItemsListener listener = new ColorItemsListener(this);
        FileManipulationsListener manipulationsListener = new FileManipulationsListener(this);
        redColorButton.addItemListener(listener);
        redColorButton.addKeyListener(manipulationsListener);
        group.add(greenColorButton);
        greenColorButton.addItemListener(listener);
        greenColorButton.addKeyListener(manipulationsListener);
        group.add(blueColorButton);
        blueColorButton.addItemListener(listener);
        blueColorButton.addKeyListener(manipulationsListener);
        redColorButton.setSelected(true);
        this.changeColor(Color.RED);
        this.setButtonAlignment(redColorButton);
        this.setButtonAlignment(blueColorButton);
        this.setButtonAlignment(greenColorButton);
        buttonPanel.add(redColorButton);
        buttonPanel.add(greenColorButton);
        buttonPanel.add(blueColorButton);
    }
    private void setButtonAlignment(JRadioButton button){
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
    }
    public void changeColor(Color color){
        drawPanel.changeColor(color);
    }
}
