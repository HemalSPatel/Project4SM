package com.example.rucafe.project4sm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.text.DecimalFormat;
import java.util.*;

public class BasketController {
    @FXML private ListView<MenuItem> lv_order;
    @FXML private TextField tf_sub;
    @FXML private TextField tf_tax;
    @FXML private TextField tf_total;
    @FXML private Button b_remove;
    @FXML private Button b_place;

    private DonutController donutController;
    private CoffeeController coffeeController;

/*
    private StoreOrder storeOrders;

    private static int orderNum = 0;
*/

/*
    public void setDonutController(DonutController controller) {
        donutController = controller;
    }

    private static ArrayList<MenuItem> order;
*/

    private RUCafeController controller;

    /**
     * Sets the main controller for this controller.
     * @param controller main controller.
     */
    public void setMainController(RUCafeController controller){
        this.controller = controller;
    }
/*
    public static ArrayList<MenuItem> getOrder(){
        return order;
    }

    public static void resetOrder(){
        if(order != null){
            order.clear();
        }
    }*/

    /**
     *
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
     *
     */
    public void initialize() {

        //updates list for the order and prints it out

        //order = new ArrayList<MenuItem>();

        //order.addAll(donutController.getDonutOrder());
        //order.addAll(coffeeController.getAddedCoffee());
/*
            for(MenuItem e: controller.getCurrentOrder().getItems()){
                if(e != null){
                    lv_order.getItems().add(e);
                }
            }*/
        //calculateSubTotal(controller.getCurrentOrder().getOrder());


        /**
         *
         */
        b_remove.setOnAction(event -> {
            int selectedID = lv_order.getSelectionModel().getSelectedIndex();
//            order.remove(selectedID);
//            lv_order.getItems().remove(selectedID);
            MenuItem removeMI = lv_order.getSelectionModel().getSelectedItem();
            controller.removeFromOrder(removeMI);
            lv_order.getItems().remove(lv_order.getSelectionModel().getSelectedItem());
            calculateSubTotal();

//            if(order.get(selectedID) instanceof Coffee) {
//                CoffeeController.getAddedCoffee().remove(order.get(selectedID));
//            } else {
//                DonutController.getDonutOrder().remove(order.get(selectedID));
//            }
        });

        /**
         *
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
                //System.out.println(StoreController.allOrders.get(0));
//                order.removeAll(donutController.getDonutOrder());
//                order.removeAll(coffeeController.getAddedCoffee());
                //order.clear();
                donutController.resetOrderDonut();
                coffeeController.resetOrderCoffee();
                calculateSubTotal();
/*
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("store-order-view.fxml"));
                    //BorderPane root = (BorderPane) loader.load();
                    StoreController storecontroller = loader.getController();
                    storecontroller.setBasketController(this);
                } catch (NullPointerException e) {
                }*/

            }
        });
    }
/*
    public void addToStoreOrder() {
        if (StoreController.allOrders == null) StoreController.allOrders = new ArrayList<Order>();
        Order curOrder = new Order();
        StoreController.allOrders.add(curOrder);
    }*/

    /**
     *
     * @return
     */
    public ListView<MenuItem> getBasket() {
        return lv_order;
    }

}
