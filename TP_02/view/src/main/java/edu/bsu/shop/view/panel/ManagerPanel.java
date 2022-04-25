package edu.bsu.shop.view.panel;

import edu.bsu.shop.view.panel.manager.OrdersPanel;

import javax.swing.*;
import java.awt.*;

import static edu.bsu.shop.view.config.GraphicalItems.CHANGE_MANAGER_PANEL_BUTTON;
import static edu.bsu.shop.view.config.GraphicalItems.CHANGE_MANAGER_PANEL_LISTENER;

public class ManagerPanel extends JPanel {

    public ManagerPanel() {
        this.setLayout(new BorderLayout());
        this.add(CHANGE_MANAGER_PANEL_BUTTON, BorderLayout.NORTH);
        CHANGE_MANAGER_PANEL_BUTTON.addActionListener(CHANGE_MANAGER_PANEL_LISTENER);
        this.add(new JScrollPane(new OrdersPanel()), BorderLayout.CENTER);
    }
}
