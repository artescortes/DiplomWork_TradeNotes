package com.example.tradenotediplomwork;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;

import static com.example.tradenotediplomwork.ConnToBD.connection;

public class InsertTokenController {

    String sql;

    @FXML
    private TextField textField2;

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField4;

    @FXML
    private TextField textField3;

    @FXML
    private Button insertTokenBtn;

    @FXML
    void initialize() {
        // assert insertTokenBtn != null : "fx:id=\"insertTokenBtn\" was not injected: check your FXML file 'inserttotablewin.fxml'.";

    }

    @FXML
    void toMainFromInsert(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("registrationandsign/mainwin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void insertTokenToTable(ActionEvent event) {
        try {
            String journalquery = "insert into crypto (name, quantity, sum_of_buy, desired_price) values (?, ?, ?, ?)";
            PreparedStatement journal = connection.prepareStatement(journalquery);
            journal.setString(1, textField1.getText());
            journal.setString(2, textField2.getText());
            journal.setString(3, textField3.getText());
            journal.setString(4, textField4.getText());
            journal.executeUpdate();
            System.out.println("Entry Saved!");
        } catch (Exception e3) {
            System.out.println("Error!");
        }

    }
}
