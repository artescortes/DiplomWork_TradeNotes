package com.example.tradenotediplomwork;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

import static com.example.tradenotediplomwork.ConnToBD.connection;

public class MainController {
    @FXML
    private TextArea mainTextArea;

    @FXML
    private TableColumn<CryptoTable, Double> columnDesiredPrice;

    @FXML
    private TableColumn<com.example.tradenotediplomwork.CryptoTable, Integer> columnId;

    @FXML
    private TableColumn<CryptoTable, Double> columnSumOfBuy;

    @FXML
    private TableColumn<CryptoTable, Double> columnQuantity;

    @FXML
    private TableColumn<CryptoTable, Text> columnName;

    @FXML
    private TableColumn<CryptoTable, Double> columnCurrentPrice;

    @FXML
    private TableColumn<CryptoTable, Double> columnCurrentCourse;


    static int tableId;
    static int tableIdKurs;

    private static ObservableList<CryptoTable> CryptoTable = FXCollections.observableArrayList();

    @FXML
    public TableView<CryptoTable> tableViewCrypto;

    @FXML
    public TableView<CryptoTable> tableViewKurs;

    @FXML
    void ShowNews(ActionEvent event) {
        mainTextArea.setText("В России хотят запретить криптовалюту");
    }

    @FXML
    void AboutProgram(ActionEvent event) throws IOException {
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
    void toInsertTokenWin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("registrationandsign/inserttotablewin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        tableViewCrypto.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                tableId = tableViewCrypto.getSelectionModel().getSelectedIndex();
            }
        });
        try {
            if (connection == null) return;
            ConnToBD connector = new ConnToBD();
            connection = connector.getConnection();
            tableViewCrypto.setItems(connector.getCryptoTable("SELECT * FROM crypto"));
            columnId.setCellValueFactory(new PropertyValueFactory<CryptoTable, Integer>("id"));
            columnName.setCellValueFactory(new PropertyValueFactory<CryptoTable, Text>("name"));
            columnQuantity.setCellValueFactory(new PropertyValueFactory<CryptoTable, Double>("quantity"));
            columnSumOfBuy.setCellValueFactory(new PropertyValueFactory<CryptoTable, Double>("sum_of_buy"));
            columnDesiredPrice.setCellValueFactory(new PropertyValueFactory<CryptoTable, Double>("desired_price"));
//            columnCurrentPrice.setCellValueFactory(new PropertyValueFactory<CryptoTable, Double>("current_price"));
//            columnCurrentCourse.setCellValueFactory(new PropertyValueFactory<CryptoTable, Double>("current_course"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}