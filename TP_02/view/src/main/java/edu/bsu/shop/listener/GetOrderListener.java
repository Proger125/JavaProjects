package edu.bsu.shop.listener;

import edu.bsu.shop.model.Order;
import lombok.RequiredArgsConstructor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

@RequiredArgsConstructor
public class GetOrderListener implements ActionListener {

    private final Order order;

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder builder = new StringBuilder();
        builder.append("Order number: ").append(order.getId()).append("\n");
        builder.append("Products:").append("\n");
        for (var product : order.getProducts()) {
            builder.append(product.getProduct().getName())
                    .append(": ")
                    .append(product.getProduct().getCost())
                    .append(" * ")
                    .append(product.getQuantity())
                    .append(" = ")
                    .append(product.getProduct().getCost()
                            .multiply(BigDecimal.valueOf(product.getQuantity())))
                    .append("\n");
        }
        builder.append("Total cost: ").append(order.getTotalCost()).append("\n");
        builder.append("Order status: ").append(order.getOrderStatus());
        JOptionPane.showMessageDialog(null, builder.toString());
    }
}
