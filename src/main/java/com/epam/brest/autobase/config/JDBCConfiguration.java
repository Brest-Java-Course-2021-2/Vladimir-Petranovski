package com.epam.brest.autobase.config;

import com.epam.brest.autobase.interfaces.IInitAndDestroyBean;
import com.epam.brest.autobase.logger.MyLogger;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static com.epam.brest.autobase.logger.MyLogger.log;

public class JDBCConfiguration implements IInitAndDestroyBean {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Properties properties = new JDBCConfiguration().getProperties();
        String driverName = properties.getProperty("jdbc.driverClassName");
            Class.forName(driverName);
            log.info("Properties loaded {}", properties);
        return DriverManager.getConnection(
                properties.getProperty("jdbc.url"),
                properties.getProperty("jdbc.username"),
                properties.getProperty("jdbc.password"));
    }

    private Properties getProperties() {
        try (InputStream inputStream = getClass().getResourceAsStream("/jdbc.properties")) {
             Properties properties = new Properties();
             properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
