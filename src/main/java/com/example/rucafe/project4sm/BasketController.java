package com.example.rucafe.project4sm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Controller class for the basket fxml file to allow the user to
 * interact with the UI
 * @author Hemal Patel, Ishika Patel
 */
public class BasketController {
    @FXML private ListView<MenuItem> lv_order;
    @FXML private TextField tf_sub;
    @FXML private TextField tf_tax;
    @FXML private TextField tf_total;
    @FXML private Button b_remove;
    @FXML private Button b_place;

    private DonutController donutController;
    private CoffeeController coffeeController;
    private RUCafeController controller;

    /**
     * Sets the main controller for this controller.
     * @param controller main controller.
     */
    public void setMainController(RUCafeController controller){
        this.controller = controller;
    }

    /**
     * Calculates the subtotal of the current items in the basket
     */
    public void calculateSubTotal(){
        ArrayList<MenuItem> order = controller.getCurrentOrder().getOrder();
        DecimalFormat df = new DecimalFormat("#.00");
        Double subtotal = 0.0;
        for(MenuItem e: order){
            if(e != null){
                subtotal += (e.getPrice() * e.getAmount());
            }
        }
        tf_sub.setText("$" + df.format(subtotal));
        tf_tax.setText("$" + df.format(subtotal * .0625));
        tf_total.setText("$" + df.format(subtotal * 1.0625));
    }

    /**
     * Contains all the set on action for the interactable function of the UI
     */
    public void initialize() {

        /**
         * Removes the selected item from the basket
         */
        b_remove.setOnAction(event -> {
            MenuItem removeMI = lv_order.getSelectionModel().getSelectedItem();
            controller.removeFromOrder(removeMI);
            lv_order.getItems().remove(lv_order.getSelectionModel().getSelectedItem());
            calculateSubTotal();

        });

        /**
         * Finalize the order based on what is in the basket at the time
         */
        b_place.setOnAction(event -> {
            if (controller.getCurrentOrder().getOrder().size() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "The basket is empty.");
                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Your order has been placed.");
                alert.showAndWait();
                lv_order.getItems().clear();
                String total = tf_total.getText().substring(1);
                controller.getCurrentOrder().setTotalPrice(Double.parseDouble(total));
                controller.addToStoreOrder();
                donutController.resetOrderDonut();
                coffeeController.resetOrderCoffee();
                calculateSubTotal();
            }
        });
    }

    /**
     * retrieves the menu items that are in the basket at that time
     * @return list of menu items
     */
    public ListView<MenuItem> getBasket() {
        return lv_order;
    }

}
