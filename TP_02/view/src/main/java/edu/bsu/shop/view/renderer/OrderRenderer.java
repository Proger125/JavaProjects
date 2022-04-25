package edu.bsu.shop.view.renderer;

import edu.bsu.shop.listener.ChangeOrderStatusListener;
import edu.bsu.shop.model.Order;

import javax.swing.*;
import java.awt.*;

import static edu.bsu.shop.view.config.GraphicalConstants.*;
import static edu.bsu.shop.view.config.GraphicalItems.getButtonFixedSize;
import static edu.bsu.shop.view.config.GraphicalItems.getOrderFixedSize;

public final class OrderRenderer {

    private OrderRenderer() {}

    public static JPanel renderOrderForManager(Order order) {
        JPanel panel = renderOrder(order);

        if (order.getOrderStatus().equals(IN_PROCESS_ORDER_STATUS)) {
            JButton confirmButton = new JButton(CONFIRM_ORDER_BUTTON_TITLE);
            confirmButton.setSize(100, 20);
            confirmButton.setLocation(370, 35);
            confirmButton.addActionListener(new ChangeOrderStatusListener("CONFIRMED_BY_MANAGER", order));
            panel.add(confirmButton);

            JButton declaimButton = new JButton(DECLAIM_ORDER_BUTTON_TITLE);
            declaimButton.setSize(100, 20);
            declaimButton.setLocation(370, 65);
            declaimButton.addActionListener(new ChangeOrderStatusListener("DECLAIMED", order));
            panel.add(declaimButton);
        }

        return panel;
    }

    public static JPanel renderOrderForAccountant(Order order) {
        JPanel panel = renderOrder(order);
        if (order.getOrderStatus().equals(CONFIRMED_BY_MANAGER_ORDER_STATUS)) {
            JButton createPaymentButton = new JButton(CREATE_PAYMENT_BUTTON_TITLE);
            createPaymentButton.setSize(getButtonFixedSize());
            createPaymentButton.setLocation(370, 35);
            createPaymentButton.addActionListener(new ChangeOrderStatusListener("READY_TO_PAY", order));
            panel.add(createPaymentButton);

            JButton declaimButton = new JButton(DECLAIM_ORDER_BUTTON_TITLE);
            declaimButton.setSize(getButtonFixedSize());
            declaimButton.setLocation(370, 65);
            declaimButton.addActionListener(new ChangeOrderStatusListener("DECLAIMED", order));
            panel.add(declaimButton);
        }
        return panel;
    }

    private static JPanel renderOrder(Order order) {
        JPanel panel = new JPanel(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setSize(getOrderFixedSize());
        panel.setMinimumSize(getOrderFixedSize());
        panel.setPreferredSize(getOrderFixedSize());

        JLabel totalCostLabel = new JLabel(order.getTotalCost().toPlainString());
        totalCostLabel.setSize(100, 20);
        totalCostLabel.setLocation(10, 5);
        panel.add(totalCostLabel);

        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        for (var product : order.getProducts()) {
            builder.append(product.getProduct().getName()).append(": ");
            builder.append("quantity = ").append(product.getQuantity()).append("<br>");
        }
        builder.append("</html>");
        JLabel productsLabel = new JLabel(builder.toString());
        productsLabel.setSize(350, 165);
        productsLabel.setLocation(10, 35);
        panel.add(productsLabel);

        JLabel orderStatusLabel = new JLabel(order.getOrderStatus());
        orderStatusLabel.setSize(200, 20);
        orderStatusLabel.setLocation(260, 5);
        panel.add(orderStatusLabel);

        return panel;
    }
}
