package com.example.tradenotediplomwork;

import java.sql.*;

public class ConnToBD extends Main {
    public static Connection connection;
    public static Statement statmt;
    public static ResultSet resultSet;

    public static Connection conn() throws SQLException, ClassNotFoundException {
        // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
        if (connection == null) {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:SqliteJavaDB.db");
            System.out.println("Connect to SQLite...");
        }
        statmt = connection.createStatement();

        String sql1;
        sql1 =  "CREATE TABLE IF NOT EXISTS  users " +
                "(id INTEGER NOT NULL," +
                "name TEXT  NOT NULL," +
                "surname TEXT NOT NULL," +
                "phone_number INTEGER NOT NULL," +
                "e_mail NVARCHAR NOT NULL," +
                "PRIMARY KEY(id))";
        statmt.executeUpdate(sql1);
        sql1 =  "CREATE TABLE IF NOT EXISTS  crypto " +
                "(id INTEGER NOT NULL," +
                "name TEXT  NOT NULL," +
                "quantity DOUBLE NOT NULL," +
                "sum_of_buy DOUBLE NOT NULL," +
                "desired_price DOUBLE NOT NULL," +
                "PRIMARY KEY(id))";
        statmt.executeUpdate(sql1);
        System.out.println("tables create!");
        return connection;

        //запрос создания таблицы пользователей
//        CREATE TABLE IF NOT EXISTS  users (
//                id INTEGER NOT NULL,
//                name TEXT  NOT NULL,
//                surname TEXT NOT NULL,
//                phone_number INTEGER NOT NULL,
//                e_mail NVARCHAR NOT NULL,
//                PRIMARY KEY(id)
//);
//Запрос создания таблицы крипты
//        CREATE TABLE IF NOT EXISTS  crypto (
//                id INTEGER NOT NULL,
//                name TEXT  NOT NULL,
//                quantity DOUBLE NOT NULL,
//                sum_of_buy DOUBLE NOT NULL,
//                desired_price DOUBLE NOT NULL,
//                PRIMARY KEY(id)
//);
    }
}