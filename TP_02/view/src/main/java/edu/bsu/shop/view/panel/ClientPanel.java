package edu.bsu.shop.view.panel;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsu.shop.controller.AddButtonListener;
import edu.bsu.shop.controller.OrderButtonListener;
import edu.bsu.shop.exception.ServerException;
import edu.bsu.shop.exception.ViewRenderException;
import edu.bsu.shop.model.Product;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static edu.bsu.shop.view.config.GraphicalConstants.ADD_PRODUCT_BUTTON_TITLE;
import static edu.bsu.shop.view.config.GraphicalItems.*;

public class ClientPanel extends JPanel {

    public ClientPanel() {
        this.setLayout(new BorderLayout());
        this.add(BASKET, BorderLayout.WEST);
        this.add(ORDER_BUTTON, BorderLayout.SOUTH);
        ORDER_BUTTON.addActionListener(new OrderButtonListener());
        Product[] products = getAllProducts();
        try {
            renderProducts(products);
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

    private Product[] getAllProducts() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/products")
                .method("GET", null)
                .build();
        try {
            ResponseBody responseBody = client.newCall(request).execute().body();
            ObjectMapper objectMapper = new ObjectMapper();
            if (responseBody != null) {
                return objectMapper.readValue(responseBody.string(), Product[].class);
            } else {
                throw new ServerException();
            }
        } catch (IOException e) {
            throw new ViewRenderException();
        }
    }

}
