package com.example.rucafe.project4sm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class RUCafeController {
    @FXML
    private Button order_donut;

    @FXML
    private void onOrderDonutClick(ActionEvent event) throws IOException {
        // Load the FXML file for the second view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("donut-view.fxml"));
        Parent secondViewParent = loader.load();

        // Create a new scene with the second view and set it on the stage
        Scene secondViewScene = new Scene(secondViewParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(secondViewScene);

        // Get the controller for the second view and initialize it
        DonutController controller = loader.getController();
        controller.initialize();
    }
}