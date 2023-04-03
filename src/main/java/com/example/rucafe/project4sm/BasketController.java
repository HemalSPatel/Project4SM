package com.example.rucafe.project4sm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.DecimalFormat;
import java.util.*;

public class BasketController {
    @FXML private ListView<String> lv_order;
    @FXML private TextField tf_sub;
    @FXML private TextField tf_tax;
    @FXML private TextField tf_total;
    @FXML private Button b_remove;
    @FXML private Button b_place;

    private DonutController donutController;
    private CoffeeController coffeeController;
    public void setDonutController(DonutController Controller) {
        donutController = Controller;
    }

    public void setCoffeeController(CoffeeController Controller) {
        coffeeController = Controller;
    }

    private void calculateSubTotal(ArrayList<MenuItem> order){
        DecimalFormat df = new DecimalFormat("#.00");
        Double subtotal = 0.0;
        for(MenuItem e: order){
            subtotal += (e.getPrice() * e.getAmount());
        }
        tf_sub.setText("$" + df.format(subtotal));
        tf_tax.setText("6.25%");
        tf_total.setText("$" + df.format(subtotal * 1.0625));
    }

    public void initialize() {

        //updates list for the order and prints it out
        ArrayList<MenuItem> order = new ArrayList<MenuItem>();
        order.addAll(DonutController.getDonutOrder());

        for(MenuItem e: order){
            lv_order.getItems().add(e.toString());
        }
        calculateSubTotal(order);

        b_remove.setOnAction(event -> {
            int selectedID = lv_order.getSelectionModel().getSelectedIndex();
            order.remove(selectedID);
            lv_order.getItems().remove(selectedID);
            calculateSubTotal(order);
        });

        b_place.setOnAction(event -> {

        });
    }


}
