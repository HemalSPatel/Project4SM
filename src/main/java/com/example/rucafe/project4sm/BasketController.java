package com.example.rucafe.project4sm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
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


    public void setDonutController(DonutController controller) {
        donutController = controller;
    }

    private static ArrayList<MenuItem> order;


    public void setCoffeeController(CoffeeController controller) {
        coffeeController = controller;
    }


    public static ArrayList<MenuItem> getOrder(){
        return order;
    }

    public static void resetOrder(){
        if(order != null){
            order.clear();
        }
    }

    private void calculateSubTotal(ArrayList<MenuItem> order){
        DecimalFormat df = new DecimalFormat("#.00");
        Double subtotal = 0.0;
        for(MenuItem e: order){
            if(e != null){
                subtotal += (e.getPrice() * e.getAmount());
            }
        }
        tf_sub.setText("$" + df.format(subtotal));
        tf_tax.setText("6.25%");
        tf_total.setText("$" + df.format(subtotal * 1.0625));
    }

    public void initialize() {

        //updates list for the order and prints it out

        order = new ArrayList<MenuItem>();

        order.addAll(donutController.getDonutOrder());
        Coffee addedCoffee = coffeeController.getAddedCoffee();
        order.add(addedCoffee);


            for(MenuItem e: order){
                if(e != null){
                    lv_order.getItems().add(e.toString());
                }
            }
            calculateSubTotal(order);



        b_remove.setOnAction(event -> {
            int selectedID = lv_order.getSelectionModel().getSelectedIndex();
            order.remove(selectedID);
            lv_order.getItems().remove(selectedID);
            calculateSubTotal(order);
        });

        b_place.setOnAction(event -> {
            if (order.size() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "The basket is empty.");
                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Your order has been placed.");
                alert.showAndWait();

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("store-order-view.fxml"));
                    //BorderPane root = (BorderPane) loader.load();
                    StoreController storecontroller = loader.getController();
                    storecontroller.setBasketController(this);
                } catch (NullPointerException e) {
                }

            }
        });
    }


}
