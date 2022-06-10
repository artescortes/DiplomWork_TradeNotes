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
                "desired_price DOUBLE NOT NULL," +
                "current_price DOUBLE NOT NULL," +
                "current_course DOUBLE NOT NULL)";
        statmt.executeUpdate(sql1);
        System.out.println("tables create!");
        return connection;
    }

    public ObservableList<CryptoTable> getCryptoTable(String selectRequest) throws SQLException {
        ObservableList<CryptoTable> res = FXCollections.observableArrayList();
        ResultSet set = statmt.executeQuery(selectRequest);
        String name;
        Double quantity, sum_of_buy, desired_price, current_price, current_course;
        int id;
        while (set.next()) {
            id = set.getInt("id");
            name = set.getString("name");
            quantity = set.getDouble("quantity");
            sum_of_buy = set.getDouble("sum_of_buy");
            desired_price = set.getDouble("desired_price");
            current_price = set.getDouble("current_price");
            current_course = set.getDouble("current_course");
            res.add(new CryptoTable(id, name, quantity, sum_of_buy, desired_price, current_price, current_course));
        }
        return res;
    }


    public Connection getConnection() {
        return connection;
    }

}
