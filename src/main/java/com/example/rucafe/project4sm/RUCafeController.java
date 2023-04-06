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
import java.util.ArrayList;

/**
 * controller class for the ru cafe fxml file that connects the UI to the backend
 * @author Hemal Patel, Ishika Patel
 */
public class RUCafeController {

    @FXML
    private Button order_donut;
    @FXML
    private Button order_coffee;
    @FXML
    private Button your_order;
    @FXML
    private Button store_order;

    private Order currentOrder = new Order();

    private StoreOrder storeOrders;

    /**
     * loads the donut fxml file when the donut button is clicked
     * @param event
     * @throws IOException
     */
    @FXML
    private void onOrderDonutClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RUCafeApplication.class.getResource("donut-view.fxml"));

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Ordering Donuts");
        Scene scene = new Scene(fxmlLoader.load(), 650, 750);

        DonutController donutsController = fxmlLoader.getController();
        donutsController.setMainController(this);


        primaryStage.initModality (Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * loads the coffee fxml file view when the coffee button is clicked
     * @param event
     * @throws IOException
     */
    @FXML
    private void onOrderCoffeeClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RUCafeApplication.class.getResource("coffee-view.fxml"));

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Ordering Coffee");
        Scene scene = new Scene(fxmlLoader.load(), 650, 750);

        CoffeeController coffeeController = fxmlLoader.getController();
        coffeeController.setMainController(this);

        primaryStage.initModality (Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * loads the basket view fxml file when the basket button is clicked
     * @param event
     * @throws IOException
     */
    @FXML
    private void onYourOrderClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RUCafeApplication.class.getResource("basket-view.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Your Order");
        Scene scene = new Scene(fxmlLoader.load(), 650, 750);

        BasketController basketController = fxmlLoader.getController();
        basketController.setMainController(this);
        try {
            basketController.getBasket().getItems().addAll(currentOrder.getOrder());
        } catch (Exception e) { }
        if(currentOrder != null){
            basketController.calculateSubTotal();
        }
        primaryStage.initModality (Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * loads the store order view fxml file when the store order button is clicked
     * @param event
     * @throws IOException
     */
    @FXML
    private void onStoreOrderClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RUCafeApplication.class.getResource("store-order-view.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Store Orders");
        Scene scene = new Scene(fxmlLoader.load(), 650, 750);
        StoreController storeController = fxmlLoader.getController();
        storeController.setMainController(this);
        try {
            for(int i=0; i<storeOrders.getStoreOrders().size(); i++){
                storeController.getOrderNumber().getItems().add(i+1);
            }
        }catch (Exception e){        }
        primaryStage.initModality (Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Adds a menu item to the current order.
     * @param item to be added to current order.
     */
    public void addToOrder(MenuItem item){
        if(currentOrder==null) currentOrder = new Order();
        currentOrder.add(item);
    }

    /**
     * Removes a menu item to the current order.
     * @param item to be removed from the current order.
     */
    public void removeFromOrder(MenuItem item){
        currentOrder.remove(item);
    }

    /**
     * Getter for the currentOrder.
     * @return order the currentOrder.
     */
    public Order getCurrentOrder() {
        return currentOrder;
    }


    /**
     * Adds order to the Store Order.
     */
    public void addToStoreOrder(){
        if(storeOrders==null) storeOrders = new StoreOrder();
        storeOrders.add(currentOrder);
        currentOrder = new Order();
    }

    /**
     * Removes orders form the Store Order.
     * @param order to be removed from the Store Order.
     */
    public void removeFromStoreOrder(Order order){
        storeOrders.remove(order);
    }

    /**
     * Getter for the StoreOrders.
     * @return StoreOrder the storeOrders.
     */
    public StoreOrder getStoreOrders() {
        return storeOrders;
    }
}
