module com.example.unit {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.unit to javafx.fxml;
    exports com.example.unit;
}