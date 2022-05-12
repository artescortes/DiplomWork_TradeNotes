package com.example.tradenotediplomwork;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("registrationandsign/loginwin.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Trade Note");
        stage.setScene(scene);
        stage.show();
        ConnToBD.conn();
    }


    private void readSettings(Stage stage) throws IOException {
        Properties prop = new Properties();
        if (new File("settings.properties").exists()){
            prop.load(new FileInputStream(new File("settings.properties")));
        }
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.setX(Double.parseDouble(prop.getProperty("posX","10")));
        stage.setY(Double.parseDouble(prop.getProperty("posY","10")));
        stage.setWidth(Double.parseDouble(prop.getProperty("width","600")));
        stage.setHeight(Double.parseDouble(prop.getProperty("height","400")));
    }

    public static void saveSettings(Stage stage) throws IOException {
        Properties prop = new Properties();
        prop.put("posX",String.valueOf(stage.getX()));
        prop.put("posY",String.valueOf(stage.getY()));
        prop.put("width",String.valueOf(stage.getWidth()));
        prop.put("height",String.valueOf(stage.getHeight()));
        prop.put("table",String.valueOf(MainController.tableId));
        //prop.put("stroka1",String.valueOf(MainController.tableViewCrypto.getSelectionModel().getSelectedIndex()));
        //prop.put("stroka2",String.valueOf(MainController.tableViewKurs.getSelectionModel().getSelectedIndex()));
        prop.store(new FileOutputStream(new File("settings.properties")),"Comments");
    }
}