package com.example.tradenotediplomwork.modalWin;

import com.example.tradenotediplomwork.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class ModalWindow {
    public static EventHandler<ActionEvent> modalWindowInsertToken(String title) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Pane pane = new Pane();

        Label message = new Label("Токен добавлен!");
        message.setLayoutX(50);
        message.setLayoutY(40);
        final double MAX_FONT_SIZE = 20.0; // define max font size you need
        message.setFont(new Font(MAX_FONT_SIZE)); // set to Label
        pane.getChildren().add(message);

        Button btn = new Button("Закрыть окно");
        btn.setLayoutX(140);
        btn.setLayoutY(100);
        btn.setOnAction(event -> window.close());
        pane.getChildren().add(btn);

        Button toMainBtn = new Button("На главную");
        toMainBtn.setLayoutX(20);
        toMainBtn.setLayoutY(100);
        pane.getChildren().add(toMainBtn);
        toMainBtn.setOnAction(event -> {
            try {

                Parent root = FXMLLoader.load(Main.class.getResource("registrationandsign/mainwin.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Scene scene = new Scene(pane, 250, 150);
        window.setScene(scene);
        window.setTitle(title);
        window.showAndWait();
        window.close();
        return null;
    }
}
