package edu.bsu.kr.kr_26_05.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class for connection pool
 */
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

    /**
     * Return connection pool instance
     * @return - connection pool instance
     */
    public static ConnectionPool getInstance() {
        while (instance == null) {
            if (isCreated.compareAndSet(false, true)) {
                instance = new ConnectionPool();
            }
        }
        return instance;
    }

    /**
     * Get connection from connection pool
     * @return connection to database
     */
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

    /**
     * Release connection
     * @param connection - connection to release
     * @return true if connection was released successfully or false otherwise
     */
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

    /**
     * Destroy connection pool
     */
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

    /**
     * Deregister drivers for databases
     */
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
