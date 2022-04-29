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
    void RegistrationHelp(ActionEvent event) {
        chatTextArea.setText("В России хотят запретить криптовалюту");
    }
}
