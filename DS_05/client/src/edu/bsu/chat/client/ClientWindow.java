package edu.bsu.chat.client;

import edu.bsu.chat.newtwork.TCPConnection;
import edu.bsu.chat.newtwork.TCPConnectionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientWindow extends JFrame implements ActionListener, TCPConnectionListener {

    static final List<Client> clients;

    static {
        clients = new ArrayList<>();
        clients.add(new Client("Sashka", "12345"));
        clients.add(new Client("Baby Bahar", "Super_baby"));
        clients.add(new Client("client", "client"));
    }

    private static final String IP_ADDR = "10.160.73.133";
    private static final int PORT = 8189;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private final JTextArea area = new JTextArea();
    private final JLabel fieldNickName = new JLabel();
    private final JTextField fieldInput = new JTextField();


    private TCPConnection connection;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClientWindow::new);
    }

    private ClientWindow(){
        AuthWindow authWindow = new AuthWindow(clients, this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setName("Client");

        area.setEditable(false);
        area.setLineWrap(true);

        fieldInput.addActionListener(this);

        this.add(area, BorderLayout.CENTER);
        this.add(fieldInput, BorderLayout.SOUTH);
        this.add(fieldNickName, BorderLayout.NORTH);
    }

    public void authorize(String login) {
        this.setVisible(true);
        this.fieldNickName.setText(login);

        try {
            connection = new TCPConnection(this, IP_ADDR, PORT);
        } catch (IOException e) {
            printMessage("Connection exception: " +  e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = fieldInput.getText();
        if (message.isBlank()){
            return;
        }

        fieldInput.setText(null);
        connection.sendString(fieldNickName.getText() + ": " + message);
    }

    @Override
    public void onConnectionReady(TCPConnection connection) {
        printMessage("Connection ready...");
    }

    @Override
    public void onReceiveString(TCPConnection connection, String string) {
        printMessage(string);
    }

    @Override
    public void onDisconnect(TCPConnection connection) {
        printMessage("Connection closed");
    }

    @Override
    public void onException(TCPConnection connection, Exception e) {
        printMessage("Connection exception: " +  e);
    }

    private synchronized void printMessage(String message){
        SwingUtilities.invokeLater(() -> {
            area.append(message + "\n");
            area.setCaretPosition(area.getDocument().getLength());
        });
    }
}
