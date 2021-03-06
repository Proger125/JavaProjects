package com.company;

import com.company.FirstView.FirstTaskPanel;
import com.company.SecondView.SecondTaskPanel;
import com.company.ThirdView.ThirdTaskPanel;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private FirstTaskPanel firstTaskPanel = new FirstTaskPanel(new BorderLayout());
    private SecondTaskPanel secondTaskPanel = new SecondTaskPanel(new GridLayout(5,5));
    private ThirdTaskPanel thirdTaskPanel = new ThirdTaskPanel(new BorderLayout());
    View(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        addElements();
        this.setVisible(true);
    }
   private void addElements(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        JTabbedPane mainPane = new JTabbedPane();
        mainPane.addTab("Первая вкладка", firstTaskPanel);
        mainPane.addTab("Вторая вкладка", secondTaskPanel);
        mainPane.addTab("Третья вкладка", thirdTaskPanel);
        mainPanel.add(mainPane);
        this.setContentPane(mainPanel);
    }
}
