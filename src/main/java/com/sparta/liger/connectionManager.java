package com.sparta.liger;

import com.sparta.liger.util.PropertiesLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connectionManager {
    private static Connection connection;
    public static Connection createConnetion() {
        Properties properties = PropertiesLoader.getProperties();
        String url = properties.getProperty("url");
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");

        try {
            connection = DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
