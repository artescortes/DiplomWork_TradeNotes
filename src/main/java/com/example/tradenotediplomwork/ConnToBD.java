package com.example.tradenotediplomwork;

import java.sql.*;

public class ConnToBD extends Main {
    public static Connection connection;
    public static Statement statmt;
    public static ResultSet resultSet;

    public static Connection conn() throws SQLException, ClassNotFoundException {
        // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
        if (connection == null) {
            System.out.println("gg");
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:SqliteJavaDB1_7.db");
            System.out.println("Connect to SQLite...");
        }
        statmt = connection.createStatement();
        return connection;
    }
}