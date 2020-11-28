package com.company.FirstView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FirstTaskPanel extends JPanel {
    private JTextArea leftArea = new JTextArea(15, 10);
    public void setLeftAreaText(ArrayList<String> list){
        leftArea.setText("");
        if (list.size() != 0){
            for (int i = 0; i < list.size(); i++) {
                leftArea.append(list.get(i) + "\n");
            }
        }
    }
    public String getLeftAreaText(){
        return leftArea.getText();
    }
    private JTextArea rightArea = new JTextArea(15, 10);
    public void setRightAreaText(ArrayList<String> list){
        rightArea.setText("");
        if (list.size() != 0){
            for (int i = 0; i < list.size(); i++) {
                rightArea.append(list.get(i) + "\n");
            }
        }
    }
    public String getRightAreaText(){
        return rightArea.getText();
    }
    private JButton toRightButton = new JButton(">");
    private JButton toLeftButton = new JButton("<");
    private Controller controller = new Controller(this);
    public FirstTaskPanel(LayoutManager manager){
        super(manager);
        this.add(leftArea, BorderLayout.WEST);
        this.add(rightArea, BorderLayout.EAST);
        this.add(toLeftButton, BorderLayout.SOUTH);
        this.add(toRightButton, BorderLayout.NORTH);
        toLeftButton.addMouseListener(new MyClickListener());
        toRightButton.addMouseListener(new MyClickListener());
    }
    private class MyClickListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == toLeftButton){
                controller.leftTransfer();
            }else{
                controller.rightTransfer();
            }
        }
    }
}
