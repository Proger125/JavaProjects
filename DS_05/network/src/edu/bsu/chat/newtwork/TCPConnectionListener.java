package edu.bsu.chat.newtwork;

public interface TCPConnectionListener {
    void onConnectionReady(TCPConnection connection);
    void onReceiveString(TCPConnection connection, String  string);
    void onDisconnect(TCPConnection connection);
    void onException(TCPConnection connection, Exception e);
}
