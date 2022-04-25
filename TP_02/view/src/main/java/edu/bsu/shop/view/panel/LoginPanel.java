package edu.bsu.shop.view.panel;

import edu.bsu.shop.listener.LoginListener;

import javax.swing.*;
import static edu.bsu.shop.view.config.GraphicalItems.*;
public class LoginPanel extends JPanel {

    public LoginPanel() {
        this.setLayout(null);
        LOGIN_LABEL.setLocation(350, 130);
        LOGIN_FIELD.setLocation(350, 150);
        PASSWORD_LABEL.setLocation(350, 180);
        PASSWORD_FIELD.setLocation(350, 200);
        LOGIN_BUTTON.setLocation(375, 225);
        LOGIN_BUTTON.addActionListener(LoginListener.getInstance());
        this.add(LOGIN_LABEL);
        this.add(LOGIN_FIELD);
        this.add(PASSWORD_LABEL);
        this.add(PASSWORD_FIELD);
        this.add(LOGIN_BUTTON);
    }
}
