package com.example.rucafe.project4sm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class RUCafeController {

    @FXML
    private Button order_donut;
    @FXML
    private Button order_coffee;
    @FXML
    private Button your_order;
    @FXML
    private Button store_order;

    @FXML
    private void onOrderDonutClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource ("donut-view.fxml"));
        Scene scene = new Scene (root);
        Stage primaryStage = new Stage ();
        primaryStage.setTitle("Order Donut");
        primaryStage.setScene (scene);

        primaryStage.initModality (Modality.APPLICATION_MODAL);
        primaryStage.show();
    }

    @FXML
    private void onOrderCoffeeClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource ("coffee-view.fxml"));
        Scene scene = new Scene (root);
        Stage primaryStage = new Stage ();
        primaryStage.setTitle("Order Coffee");
        primaryStage.setScene (scene);

        primaryStage.initModality (Modality.APPLICATION_MODAL);
        primaryStage.show();
    }

    @FXML
    private void onYourOrderClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource ("basket-view.fxml"));
        Scene scene = new Scene (root);
        Stage primaryStage = new Stage ();
        primaryStage.setTitle("Your Order");
        primaryStage.setScene (scene);

        primaryStage.initModality (Modality.APPLICATION_MODAL);
        primaryStage.show();
    }

    @FXML
    private void onStoreOrderClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource ("store-order-view.fxml"));
        Scene scene = new Scene (root);
        Stage primaryStage = new Stage ();
        primaryStage.setTitle("Store Orders");
        primaryStage.setScene (scene);

        primaryStage.initModality (Modality.APPLICATION_MODAL); // default
        primaryStage.show();
    }
    // when placing an order you and put up a alert window to notify the user that their order has been placed
}