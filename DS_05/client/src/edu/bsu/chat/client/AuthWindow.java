package edu.bsu.chat.client;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AuthWindow extends JFrame {
    private final JTextField loginField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();

    private final ClientWindow window;

    public AuthWindow(List<Client> clients, ClientWindow window){
        this.window = window;

        this.setName("Authentication");
        this.setSize(200, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(5,1));

        mainPanel.add(new JLabel("Login:"));
        mainPanel.add(loginField);

        mainPanel.add(new JLabel("Password:"));
        mainPanel.add(passwordField);

        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(new AuthListener(this, clients));
        mainPanel.add(enterButton);

        this.setContentPane(mainPanel);
    }

    public String getLogin(){
        return loginField.getText();
    }

    public String getPassword(){
        return passwordField.getText();
    }

    public void authorize() {
        this.dispose();
        window.authorize(loginField.getText());
    }
}
