package com.company.FirstView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FirstTaskPanel extends JPanel {
    private final JButton toRightButton = new JButton(">");
    private final JButton toLeftButton = new JButton("<");
    private final Controller controller = new Controller(this);
    private final JList<String> leftList = new JList<String>(controller.getList1());
    private final JList<String> rightList = new JList<String>(controller.getList2());
    public FirstTaskPanel(LayoutManager manager){
        super(manager);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(toLeftButton, BorderLayout.SOUTH);
        panel.add(toRightButton, BorderLayout.NORTH);
        this.add(leftList, BorderLayout.WEST);
        this.add(rightList, BorderLayout.EAST);
        this.add(panel, BorderLayout.CENTER);
        //this.add(toLeftButton, BorderLayout.SOUTH);
        //this.add(toRightButton, BorderLayout.NORTH);
        toLeftButton.addMouseListener(new MyClickListener());
        toRightButton.addMouseListener(new MyClickListener());
    }
    private class MyClickListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton button = (JButton)e.getSource();
            if (button == toLeftButton){
                if (!rightList.isSelectionEmpty()){
                    int[] indexes = rightList.getSelectedIndices();
                    for (int i = 0; i < indexes.length; i++){
                        controller.getList1().addElement(controller.getList2().getElementAt(indexes[i]));
                    }
                    for (int i = 0; i < indexes.length; i++){
                        controller.getList2().removeElementAt(indexes[i] - i);
                    }
                }
            }else{
                if (!leftList.isSelectionEmpty()){
                    int[] indexes = leftList.getSelectedIndices();
                    for (int i = 0; i < indexes.length; i++){
                        controller.getList2().addElement(controller.getList1().getElementAt(indexes[i]));
                    }
                    for (int i = 0; i < indexes.length; i++){
                        controller.getList1().removeElementAt(indexes[i] - i);
                    }
                }
            }
        }
    }
}
