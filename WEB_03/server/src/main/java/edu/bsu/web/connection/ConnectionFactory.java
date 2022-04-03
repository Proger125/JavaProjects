package edu.bsu.web.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static final String URL;

    private static final String DB_URL = "db.url";

    private static final String DB_DRIVER = "db.driver";

    private static final String DB_USERNAME = "db.username";

    private static final String DB_PASSWORD = "db.password";

    private static final Properties properties = new Properties();

    private static final String RESOURCE_FILE = "\\db.properties";

    static {
        String driver = null;
        try(InputStream stream = ConnectionFactory.class.getClassLoader().getResourceAsStream(RESOURCE_FILE)) {
            properties.load(stream);
            driver = properties.getProperty(DB_DRIVER);
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to register driver: " + driver, e);
        } catch (IOException e) {
            throw new RuntimeException("Unable to find properties file: " + RESOURCE_FILE, e);
        }
        URL = properties.getProperty(DB_URL);
    }

    static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                URL,
                properties.getProperty(DB_USERNAME),
                properties.getProperty(DB_PASSWORD));
    }
}
