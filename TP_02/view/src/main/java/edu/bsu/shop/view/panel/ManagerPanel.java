package edu.bsu.shop.view.panel;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsu.shop.exception.ServerException;
import edu.bsu.shop.exception.ViewRenderException;
import edu.bsu.shop.model.Order;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static edu.bsu.shop.view.config.GraphicalConstants.CONFIRM_ORDER_BUTTON_TITLE;
import static edu.bsu.shop.view.config.GraphicalConstants.DECLAIM_ORDER_BUTTON_TITLE;
import static edu.bsu.shop.view.config.GraphicalItems.getOrderFixedSize;

public class ManagerPanel extends JPanel {

    private static final String IN_PROCESS_ORDER_STRING = "IN_PROCESS";

    public ManagerPanel() {
        this.setLayout(new BorderLayout());
        Order[] orders = getAllOrders();
        renderOrders(orders);
    }

    private void renderOrders(Order[] orders) {
        JPanel orderPanel = new JPanel(new GridLayout(orders.length, 1));
        for (var order : orders) {
            orderPanel.add(renderOrder(order));
        }
        this.add(new JScrollPane(orderPanel), BorderLayout.CENTER);
    }

    private JPanel renderOrder(Order order) {
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
        orderStatusLabel.setSize(100, 20);
        orderStatusLabel.setLocation(260, 5);
        panel.add(orderStatusLabel);

        if (order.getOrderStatus().equals(IN_PROCESS_ORDER_STRING)) {
                JButton confirmButton = new JButton(CONFIRM_ORDER_BUTTON_TITLE);
                confirmButton.setSize(100, 20);
                confirmButton.setLocation(370, 35);
                panel.add(confirmButton);

                JButton declaimButton = new JButton(DECLAIM_ORDER_BUTTON_TITLE);
                declaimButton.setSize(100, 20);
                declaimButton.setLocation(370, 65);
                panel.add(declaimButton);
        }

        return panel;
    }

    private Order[] getAllOrders() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/orders")
                .method("GET", null)
                .build();
        try {
            ResponseBody responseBody = client.newCall(request).execute().body();
            ObjectMapper objectMapper = new ObjectMapper();
            if (responseBody != null) {
                return objectMapper.readValue(responseBody.string(), Order[].class);
            } else {
                throw new ServerException();
            }
        } catch (IOException e) {
            throw new ViewRenderException();
        }
    }
}
