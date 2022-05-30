package com.example.tradenotediplomwork.modalWin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModalWinAboutProg {
    public static EventHandler<ActionEvent> modalWindowAboutProgram(String title) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Pane pane = new Pane();

        Label message = new Label("Версия программы 1.0 \n" +
                "ЧГУ им. И.Н. Ульянова \n" +
                "Студент 4 курса, Факультета прикладной математики, \n" +
                "физики и информационных технологий \n" +
                "Козловский Артём Сергеевич ");
        message.setLayoutX(50);
        message.setLayoutY(40);
        final double MAX_FONT_SIZE = 20.0; // define max font size you need
        message.setFont(new Font(MAX_FONT_SIZE)); // set to Label
        pane.getChildren().add(message);

        Button btn = new Button("Закрыть окно");
        btn.setLayoutX(255);
        btn.setLayoutY(200);
        btn.setOnAction(event -> window.close());
        pane.getChildren().add(btn);
        Scene scene = new Scene(pane, 575, 250);
        window.setScene(scene);
        window.setTitle(title);
        window.showAndWait();
        window.close();
        return null;
    }
}
