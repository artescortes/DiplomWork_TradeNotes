module com.example.tradenotediplomwork {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tradenotediplomwork to javafx.fxml;
    exports com.example.tradenotediplomwork;
}