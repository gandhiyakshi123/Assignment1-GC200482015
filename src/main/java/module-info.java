module com.example.assignment1gc200482015 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.assignment1gc200482015 to javafx.fxml;
    exports com.example.assignment1gc200482015;
}