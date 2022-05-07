package com.example.tradenotediplomwork;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.jar.Attributes;

import static com.example.tradenotediplomwork.ConnToBD.connection;
import static com.example.tradenotediplomwork.ConnToBD.statmt;

public class MainController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea mainTextArea;

    @FXML
    private Button needHelp;

    @FXML
    private Button mainNewsBtn;

    @FXML
    private Button addToken;

    @FXML
    private TextField textfield1, textfield2, textfield3,
            textfield4, textfield5;


    TableView tableView;
    private static String id;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    void ShowNews(ActionEvent event) {
        mainTextArea.setText("В России хотят запретить криптовалюту");
    }

    @FXML
    void ShowContacts(ActionEvent event) {
        String contact = new String();
        contact = "Контакты компании: " +
                "Номер телефона: +79874563652 " +
                "E-mail - artem.fomichev.2000@mail.ru";
        mainTextArea.setText(contact);
    }

    @FXML
    void AboutProgram(ActionEvent event) {
        String aboutCompany = new String();
        aboutCompany = "ЧГУ им. И.Н. Ульянова.\n" +
                "Студент 4 курса, Факультета прикладной математики, физики и информационных технологий \n" +
                "Козловский Артём Сергеевич";
        mainTextArea.setText(aboutCompany);
    }

    @FXML
    void needHelp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("registrationandsign/chatbot.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void toMainFromChat(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("registrationandsign/mainwin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void menuItemTransactions(ActionEvent event) {
        mainTextArea.setText("Hi");
    }
}
