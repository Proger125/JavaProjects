package edu.bsu.web.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConnectionPool {

    private static final int DEFAULT_POOL_SIZE = 4;

    private static ConnectionPool instance = new ConnectionPool();

    private static final AtomicBoolean isCreated = new AtomicBoolean(false);

    private final BlockingQueue<ProxyConnection> freeConnections;

    private final BlockingQueue<ProxyConnection> usedConnections;

    private ConnectionPool() {
        freeConnections = new LinkedBlockingQueue<>(DEFAULT_POOL_SIZE);
        usedConnections = new LinkedBlockingQueue<>(DEFAULT_POOL_SIZE);

        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                Connection connection = ConnectionFactory.createConnection();
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                freeConnections.put(proxyConnection);
            } catch (SQLException | InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }
        if (freeConnections.isEmpty()) {
            throw new RuntimeException("Unable to create all connections");
        }
    }

    public static ConnectionPool getInstance() {
        while (instance == null) {
            if (isCreated.compareAndSet(false, true)) {
                instance = new ConnectionPool();
            }
        }
        return instance;
    }

    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            usedConnections.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        if (!(connection instanceof ProxyConnection)) {
            return false;
        }
        usedConnections.remove(connection);

        try {
            freeConnections.put((ProxyConnection) connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return true;
    }

    public void destroy() {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (InterruptedException | SQLException exception) {
                Thread.currentThread().interrupt();
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()){
            Driver driver = drivers.nextElement();
            try{
                DriverManager.deregisterDriver(driver);
            } catch (SQLException throwable) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
