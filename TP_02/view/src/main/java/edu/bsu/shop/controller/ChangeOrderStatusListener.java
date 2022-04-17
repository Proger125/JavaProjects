package edu.bsu.shop.controller;

import edu.bsu.shop.model.Order;
import lombok.RequiredArgsConstructor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@RequiredArgsConstructor
public class ChangeOrderStatusListener implements ActionListener {

    private final String newStatus;

    private final Order order;

    @Override
    public void actionPerformed(ActionEvent e) {
        order.setOrderStatus(newStatus);

    }
}
