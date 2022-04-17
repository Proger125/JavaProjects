package edu.bsu.shop.controller;

import edu.bsu.shop.model.Product;
import edu.bsu.shop.view.config.ViewConfig;
import lombok.RequiredArgsConstructor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@RequiredArgsConstructor
public class AddButtonListener implements ActionListener {

    private final Product product;

    @Override
    public void actionPerformed(ActionEvent e) {
        String result = JOptionPane.showInputDialog(null, "Quantity of product");
        try {
            int quantity = Integer.parseInt(result);
            ViewConfig.getInstance().addProduct(product, quantity);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Incorrect number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
