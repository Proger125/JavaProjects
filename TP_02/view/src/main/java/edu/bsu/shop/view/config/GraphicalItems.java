package edu.bsu.shop.view.config;

import edu.bsu.shop.model.Product;
import edu.bsu.shop.view.CustomFrame;
import edu.bsu.shop.view.panel.LoginPanel;

import javax.swing.*;
import java.awt.*;

import static edu.bsu.shop.view.config.GraphicalConstants.*;
public final class GraphicalItems {
    public static final JLabel LOGIN_LABEL = new JLabel(LOGIN_LABEL_TITLE);
    public static final JTextField LOGIN_FIELD = new JTextField();

    public static final JLabel PASSWORD_LABEL = new JLabel(PASSWORD_LABEL_TITLE);
    public static final JTextField PASSWORD_FIELD = new JTextField();

    public static final JButton LOGIN_BUTTON = new JButton(LOGIN_BUTTON_TITLE);
    public static final JButton ORDER_BUTTON = new JButton(ORDER_BUTTON_TITLE);

    public static final JList<String> BASKET = new JList<>(ViewConfig.getInstance().getBasketModel());

    public static final JPanel LOGIN_PANEL = new LoginPanel();

    public static final JFrame MAIN_FRAME = new CustomFrame("Work Window");

    static {
        LOGIN_LABEL.setSize(100, 20);
        LOGIN_FIELD.setSize(100, 20);
        PASSWORD_LABEL.setSize(100, 20);
        PASSWORD_FIELD.setSize(100, 20);

        LOGIN_BUTTON.setSize(70, 20);
    }

    public static Dimension getProductFixedSize() {
        return new Dimension(400, 80);
    }

    public static Dimension getOrderFixedSize() {
        return new Dimension(400, 200);
    }
}
