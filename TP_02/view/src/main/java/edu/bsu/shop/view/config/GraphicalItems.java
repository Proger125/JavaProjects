package edu.bsu.shop.view.config;

import edu.bsu.shop.view.panel.LoginPanel;

import javax.swing.*;
import static edu.bsu.shop.view.config.GraphicalConstants.*;
public final class GraphicalItems {
    public static JLabel LOGIN_LABEL = new JLabel(LOGIN_LABEL_TITLE);
    public static JTextField LOGIN_FIELD = new JTextField();

    public static JLabel PASSWORD_LABEL = new JLabel(PASSWORD_LABEL_TITLE);
    public static JTextField PASSWORD_FIELD = new JTextField();

    public static JButton LOGIN_BUTTON = new JButton(LOGIN_BUTTON_TITLE);

    public static JPanel LOGIN_PANEL = new LoginPanel();

    static {
        LOGIN_LABEL.setSize(100, 20);
        LOGIN_FIELD.setSize(100, 20);
        PASSWORD_LABEL.setSize(100, 20);
        PASSWORD_FIELD.setSize(100, 20);

        LOGIN_BUTTON.setSize(70, 20);
    }
}
