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
    public void setDonutController(DonutController Controller) {
        donutController = Controller;
    }

    public void initialize() {

        ArrayList<MenuItem> order = new ArrayList<MenuItem>();
        order.addAll(DonutController.getDonutOrder());

        for(MenuItem e: order){
            lv_order.getItems().add(e.toString());
        }

        b_remove.setOnAction(event -> {

        });

        b_place.setOnAction(event -> {

        });
    }


}
