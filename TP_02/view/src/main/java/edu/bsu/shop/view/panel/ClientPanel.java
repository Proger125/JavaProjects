package edu.bsu.shop.view.panel;

import edu.bsu.shop.listener.AddButtonListener;
import edu.bsu.shop.listener.GetOrderListener;
import edu.bsu.shop.listener.OrderButtonListener;
import edu.bsu.shop.model.Order;
import edu.bsu.shop.model.Product;
import edu.bsu.shop.util.HttpRequestSender;
import edu.bsu.shop.view.config.ViewConfig;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static edu.bsu.shop.view.config.GraphicalConstants.*;
import static edu.bsu.shop.view.config.GraphicalItems.*;

public class ClientPanel extends JPanel {

    public ClientPanel() {
        this.setLayout(new BorderLayout());
        this.add(BASKET, BorderLayout.WEST);
        this.add(ORDER_BUTTON, BorderLayout.SOUTH);
        ORDER_BUTTON.addActionListener(new OrderButtonListener());
        Product[] products = HttpRequestSender.getAllProducts();
        Order[] orders = HttpRequestSender.getUserOrders(ViewConfig.getInstance().getUser().getId());
        try {
            renderProducts(products);
            renderOrders(orders);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong...", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void renderProducts(Product[] products) throws IOException {
        JPanel productPanel = new JPanel(new GridLayout(products.length, 1));
        for (var product : products) {
            productPanel.add(renderProduct(product));
        }
        this.add(new JScrollPane(productPanel), BorderLayout.CENTER);
    }

    private void renderOrders(Order[] orders) {
        JPanel orderPanel = new JPanel(new GridLayout(orders.length, 1));
        for (var order : orders) {
            orderPanel.add(renderOrder(order));
        }

        this.add(new JScrollPane(orderPanel), BorderLayout.EAST);
    }

    private JButton renderOrder(Order order) {
        JButton button = new JButton(order.getId().toString());
        button.setPreferredSize(new Dimension(100, 50));
        switch (order.getOrderStatus()) {
            case IN_PROCESS_ORDER_STATUS:
                button.setBackground(Color.YELLOW);
                break;
            case CONFIRMED_BY_MANAGER_ORDER_STATUS:
                button.setBackground(Color.BLUE);
                break;
            case READY_TO_PAY_ORDER_STATUS:
                button.setBackground(Color.GREEN);
                break;
            case DECLAIMED_ORDER_STATUS:
                button.setBackground(Color.RED);
                break;
        }
        button.addActionListener(new GetOrderListener(order));
        return button;
    }

    private JPanel renderProduct(Product product) {
        JPanel panel = new JPanel(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setSize(getProductFixedSize());
        panel.setMinimumSize(getProductFixedSize());
        panel.setPreferredSize(getProductFixedSize());

        JLabel nameLabel = new JLabel(product.getName());
        nameLabel.setSize(100, 20);
        nameLabel.setLocation(10, 5);
        panel.add(nameLabel);

        JLabel descriptionLabel = new JLabel(product.getDescription());
        descriptionLabel.setSize(250, 45);
        descriptionLabel.setLocation(10, 35);
        panel.add(descriptionLabel);

        JLabel costLabel = new JLabel(product.getCost().toPlainString());
        costLabel.setSize(40, 20);
        costLabel.setLocation(260, 30);
        panel.add(costLabel);

        JButton addButton = new JButton(ADD_PRODUCT_BUTTON_TITLE);
        addButton.addActionListener(new AddButtonListener(product));
        addButton.setSize(70, 20);
        addButton.setLocation(260, 60);
        panel.add(addButton);

        return panel;
    }
}
