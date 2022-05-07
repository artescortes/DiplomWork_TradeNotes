package com.example.tradenotediplomwork;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ChatBot extends MainController{
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
    void ShowContacts(ActionEvent event) {
        String contact = new String();
        contact = "Контакты компании: "  + "\n" +
                "Номер телефона: +79874563652 " + "\n" +
                "E-mail - artem.fomichev.2000@mail.ru";
        chatTextArea.setText(contact);
    }

}
