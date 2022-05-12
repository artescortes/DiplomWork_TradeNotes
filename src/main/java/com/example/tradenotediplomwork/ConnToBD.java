package com.example.tradenotediplomwork;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ConnToBD extends Main {
    public static Connection connection;
    public static Statement statmt;

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
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT  NOT NULL," +
                "surname TEXT NOT NULL," +
                "phone_number INTEGER NOT NULL," +
                "e_mail NVARCHAR(100) NOT NULL)";
        statmt.executeUpdate(sql1);
        sql1 =  "CREATE TABLE IF NOT EXISTS  crypto " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT  NOT NULL," +
                "quantity DOUBLE NOT NULL," +
                "sum_of_buy DOUBLE NOT NULL," +
                "desired_price DOUBLE NOT NULL)";
        statmt.executeUpdate(sql1);
        System.out.println("tables create!");
        return connection;
    }

    public ObservableList<CryptoTable> getCryptoTable(String selectRequest) throws SQLException {
        ObservableList<CryptoTable> res = FXCollections.observableArrayList();
        ResultSet set = statmt.executeQuery(selectRequest);
        String name;
        Double quantity, sum_of_buy, desired_price;
        int id;
        while (set.next()) {
            id = set.getInt("id");
            name = set.getString("name");
            quantity = set.getDouble("quantity");
            sum_of_buy = set.getDouble("sum_of_buy");
            desired_price = set.getDouble("desired_price");
            res.add(new CryptoTable(id, name, quantity, sum_of_buy, desired_price));
        }
        return res;
    }
    public Connection getConnection() {
        return connection;
    }
}

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
