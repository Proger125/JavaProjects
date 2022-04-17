package edu.bsu.shop.view.config;

import edu.bsu.shop.model.Product;
import edu.bsu.shop.model.ProductOrder;
import edu.bsu.shop.model.User;
import lombok.Data;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ViewConfig {
    private static final ViewConfig INSTANCE = new ViewConfig();

    private User user;

    private DefaultListModel<String> basketModel = new DefaultListModel<>();

    private List<ProductOrder> basket = new ArrayList<>();

    private BigDecimal totalCost = new BigDecimal(0);

    private ViewConfig(){}

    public static ViewConfig getInstance() {
        return INSTANCE;
    }

    public void addProduct(Product product, int quantity) {
        BigDecimal cost = product.getCost().multiply(BigDecimal.valueOf(quantity));
        String productStr = product.getName() + "      Cost: " + product.getCost() + "*" + quantity + "=" + cost;
        totalCost = totalCost.add(cost);
        basketModel.addElement(productStr);
        basket.add(new ProductOrder(product, quantity));
    }
}
