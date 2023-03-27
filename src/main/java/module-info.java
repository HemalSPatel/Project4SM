module com.example.rucafe.project4sm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rucafe.project4sm to javafx.fxml;
    exports com.example.rucafe.project4sm;
}