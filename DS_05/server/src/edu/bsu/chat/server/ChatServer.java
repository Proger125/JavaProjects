package edu.bsu.chat.server;

import edu.bsu.chat.newtwork.TCPConnection;
import edu.bsu.chat.newtwork.TCPConnectionListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer implements TCPConnectionListener {

    private final List<TCPConnection> connections = new ArrayList<>();

    public static void main(String[] args) {
        new ChatServer();
    }

    private ChatServer(){
        System.out.println("Server running...");
        try(ServerSocket serverSocket = new ServerSocket(8189)){
            while (true){
                try{
                    new TCPConnection(this, serverSocket.accept());
                } catch (IOException e){
                    System.out.println("TCPConnection exception: " + e);
                }
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void onConnectionReady(TCPConnection connection) {
        connections.add(connection);
        sendToAllConnections("Client connected: " + connection);
    }

    @Override
    public synchronized void onReceiveString(TCPConnection connection, String string) {
        sendToAllConnections(string);
    }

    @Override
    public synchronized void onDisconnect(TCPConnection connection) {
        connections.remove(connection);
        sendToAllConnections("Client disconnected: " + connection);
    }

    @Override
    public synchronized void onException(TCPConnection connection, Exception e) {
        System.out.println("TCPConnection exception: " + e);
    }

    private void sendToAllConnections(String string){
        System.out.println(string);
        for (var connection : connections){
            connection.sendString(string);
        }
    }
}
