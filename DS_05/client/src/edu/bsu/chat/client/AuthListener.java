package edu.bsu.chat.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AuthListener implements ActionListener {

    private final AuthWindow window;
    private final List<Client> clients;

    public AuthListener(AuthWindow window, List<Client> clients){
        this.window = window;
        this.clients = clients;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String login = window.getLogin();
        String password = window.getPassword();
        boolean flag = false;
        for (var client : clients){
            if(client.getLogin().equals(login) && client.getPassword().equals(password)){
                JOptionPane.showMessageDialog(null, "You are successfully authorized");
                window.authorize();
                window.dispose();
                flag = true;
            }
        }
        if (!flag){
            JOptionPane.showMessageDialog(null, "There is such user in database");
        }
    }
}
