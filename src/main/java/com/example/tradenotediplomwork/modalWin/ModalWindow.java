package com.example.tradenotediplomwork.modalWin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModalWindow {
    public static EventHandler<ActionEvent> modalWindowInsertToken (String title) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Pane pane = new Pane();

        Label message  = new Label("Токен добавлен!");

        Button btn = new Button("close");
        btn.setAlignment(Pos.CENTER);
        btn.setOnAction(event -> window.close());
        pane.getChildren().add(btn);


        Scene scene = new Scene(pane, 250, 150);
        window.setScene(scene);
        window.setTitle(title);
        window.showAndWait();
        return null;
    }
}
