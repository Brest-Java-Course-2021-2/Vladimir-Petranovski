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

    private static final Properties properties = new Properties();
    private static final String URL;
    static Connection connection;

    static {
        try {
            properties.load(new FileInputStream("src/main/resources/jdbc.properties"));
            String driverName = properties.getProperty("jdbc.driverClassName");
            Class.forName(driverName);
            log.info("Properties loaded {}", properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        URL = properties.getProperty("jdbc.url");
    }

    public static Connection getConnection() throws SQLException {
            connection = DriverManager.getConnection(URL, properties);
            return connection;
    }

//    public static Connection getConnection() throws SQLException {
//        Properties properties = new JDBCConfiguration().getProperties();
//        return DriverManager.getConnection(
//                properties.getProperty("jdbc.url"),
//                properties.getProperty("jdbc.username"),
//                properties.getProperty("jdbc.password"));
//    }

//    private Properties getProperties() {
////        try(InputStream in = new FileInputStream("src/main/resources/jdbc.properties")) {
////            Properties properties = new Properties();
////            properties.load(in);
////            return properties;
////        } catch (Exception e) {
////            log.info("Could't find properties");
////            e.printStackTrace();
////            return null;
////        }
//
//        try (InputStream inputStream = getClass().getResourceAsStream("/src/main/resources/jdbc.properties");
//             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
//            Properties properties = new Properties();
//            while (bufferedReader.readLine() != null) {
//                properties.load(bufferedReader);
//            }
//            return properties;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
////        try {
////            Properties properties = new Properties();
////            properties.load(new FileReader("src/main/resources/jdbc.properties"));
////            return properties;
////        } catch (Exception e) {
////            log.info("Could't find properties");
////            e.printStackTrace();
////            return null;
////        }
//    }
}
