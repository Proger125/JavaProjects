package edu.bsu.shop.listener;

import edu.bsu.shop.view.panel.manager.AddNewProductPanel;
import edu.bsu.shop.view.panel.manager.OrdersPanel;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static edu.bsu.shop.view.config.GraphicalItems.*;

@Setter
public class ChangeManagerPanelListener implements ActionListener {

    private ManagerPanelType type;

    @Override
    public void actionPerformed(ActionEvent e) {
        MAIN_FRAME.getContentPane().removeAll();
        if (type == ManagerPanelType.ADD_PRODUCT_PANEL) {
            MAIN_FRAME.getContentPane().add(new JScrollPane(new AddNewProductPanel()), BorderLayout.CENTER);
            CHANGE_MANAGER_PANEL_LISTENER.setType(ManagerPanelType.ORDERS_PANEL);
        } else {
            MAIN_FRAME.getContentPane().add(new JScrollPane(new OrdersPanel()), BorderLayout.CENTER);
            CHANGE_MANAGER_PANEL_LISTENER.setType(ManagerPanelType.ADD_PRODUCT_PANEL);
        }
        MAIN_FRAME.add(CHANGE_MANAGER_PANEL_BUTTON, BorderLayout.NORTH);
        repaintFrame();
    }
}
