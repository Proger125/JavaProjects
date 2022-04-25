package edu.bsu.shop.view.panel;

import edu.bsu.shop.model.Order;
import edu.bsu.shop.util.HttpRequestSender;
import edu.bsu.shop.view.renderer.OrderRenderer;

import javax.swing.*;
import java.awt.*;

public class AccountantPanel extends JPanel {

    public AccountantPanel() {
        Order[] orders = HttpRequestSender.getAllOrders();
        this.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new GridLayout(orders.length, 1));
        for (var order : orders) {
            centerPanel.add(OrderRenderer.renderOrderForAccountant(order));
        }
        this.add(new JScrollPane(centerPanel), BorderLayout.CENTER);
    }
}
