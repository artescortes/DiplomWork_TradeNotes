package com.example.tradenotediplomwork;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatBot {
    @FXML
    private TextArea chatTextArea;

    @FXML
    private Button registrationBtn;

    @FXML
    private Button contactChatBtn;

    @FXML
    void RegistrationHelp(ActionEvent event) {
        chatTextArea.setText("Здесь нужная при регистрации информация");
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
    void ShowContacts(ActionEvent event) {
        String contact = new String();
        contact = "Контакты компании: "  + "\n" +
                "Номер телефона: +79874563652 " + "\n" +
                "E-mail - artem.fomichev.2000@mail.ru";
        chatTextArea.setText(contact);
    }

}
