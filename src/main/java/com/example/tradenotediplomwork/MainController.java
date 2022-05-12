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
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static com.example.tradenotediplomwork.ConnToBD.connection;

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
    private TableColumn<CryptoTable, Double> columnDesiredPrice;

    @FXML
    private TableColumn<com.example.tradenotediplomwork.CryptoTable, Integer> columnId;

    @FXML
    private TableColumn<CryptoTable, Double> columnSumOfBuy;

    @FXML
    private TableColumn<CryptoTable, Double> columnQuantity;

    @FXML
    private TableColumn<CryptoTable, Text> columnName;

    static int tableId;
    static int tableIdKurs;

    private static ObservableList<CryptoTable> CryptoTable = FXCollections.observableArrayList();

    @FXML
    public TableView<CryptoTable> tableViewCrypto;

    @FXML
    public TableView tableViewKurs;


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
    void toInsertTokenWin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("registrationandsign/inserttotablewin.fxml"));
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


    private void DatabaseInfo() throws SQLException, ClassNotFoundException {
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        tableViewKurs.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                tableId = tableViewKurs.getSelectionModel().getSelectedIndex();
            }
        });

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
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}