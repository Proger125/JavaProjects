package edu.bsu.shop.view.panel.manager;

import edu.bsu.shop.model.Order;
import edu.bsu.shop.util.HttpRequestSender;
import edu.bsu.shop.view.renderer.OrderRenderer;

import javax.swing.*;
import java.awt.*;
public class OrdersPanel extends JPanel {

    public OrdersPanel() {
        Order[] orders = HttpRequestSender.getAllOrders();
        this.setLayout(new GridLayout(orders.length, 1));
        for (var order : orders) {
            this.add(OrderRenderer.renderOrderForManager(order));
        }
    }
}
