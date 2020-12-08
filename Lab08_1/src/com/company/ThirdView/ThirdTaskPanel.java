package com.company.ThirdView;

import javax.swing.*;
import java.awt.*;

public class ThirdTaskPanel extends JPanel {
    ImageIcon selectedIcon = new ImageIcon("src/com/company/images/icons8-проверено-40.png");
    ImageIcon hoverIcon = new ImageIcon("src/com/company/images/icons8-iphone-spinner-40.png");
    ImageIcon releasedIcon = new ImageIcon("src/com/company/images/icons8-информация-40.png");
    ImageIcon unSelectedIcon = new ImageIcon("src/com/company/images/icons8-добавить-40.png");
    public ThirdTaskPanel(LayoutManager manager){
        super(manager);
        JRadioButton westButton = new JRadioButton("Левая кнопка");
        addAllFunctionalToRadioButton(westButton);
        JRadioButton eastButton = new JRadioButton("Правая кнопка");
        addAllFunctionalToRadioButton(eastButton);
        JRadioButton northButton = new JRadioButton("Верхняя кнопка");
        addAllFunctionalToRadioButton(northButton);
        JRadioButton southButton = new JRadioButton("Нижняя кнопка");
        addAllFunctionalToRadioButton(southButton);
        JRadioButton centerButton = new JRadioButton("Центральная кнопка");
        addAllFunctionalToRadioButton(centerButton);
        this.add(westButton, BorderLayout.WEST);
        this.add(eastButton, BorderLayout.EAST);
        this.add(northButton, BorderLayout.NORTH);
        this.add(southButton, BorderLayout.SOUTH);
        this.add(centerButton, BorderLayout.CENTER);
    }
    private void addAllFunctionalToRadioButton(JRadioButton button){
        button.setIcon(unSelectedIcon);
        button.setSelectedIcon(selectedIcon);
        button.setPressedIcon(releasedIcon);
        button.setRolloverIcon(hoverIcon);
        button.setVerticalAlignment(JRadioButton.CENTER);
        button.setHorizontalAlignment(JRadioButton.CENTER);
    }


}