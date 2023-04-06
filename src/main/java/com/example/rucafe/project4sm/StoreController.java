package com.example.rucafe.project4sm;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class StoreController {
    @FXML
    private Button b_cancel;
    @FXML
    private Button b_export;
    @FXML
    private ComboBox<Integer> cb_ordernum;
    @FXML
    private ListView<MenuItem> lv_storeorders;
    @FXML
    private TextField tf_total;
    private RUCafeController controller;

    /**
     * Sets the main controller for this controller.
     * @param controller main controller.
     */
    public void setMainController(RUCafeController controller){
        this.controller = controller;
    }

    public static ArrayList<Order> allOrders;

    /**
     *
     */
    public void initialize() {
        /**
         *
         */
        b_cancel.setOnAction(event -> {
            int remove = cb_ordernum.getSelectionModel().getSelectedIndex();
            lv_storeorders.getItems().clear();
            if(remove >= 0) {
                controller.removeFromStoreOrder(controller.getStoreOrders().getStoreOrders().get(remove));
                cb_ordernum.getItems().removeAll(cb_ordernum.getItems());
                for(int i = 0; i < controller.getStoreOrders().getStoreOrders().size(); i ++){
                    cb_ordernum.getItems().add(i+1);
                }
            }
        });

        /**
         *
         */
        b_export.setOnAction(event -> {
            ArrayList<Order> allOrders = controller.getStoreOrders().getStoreOrders();
            DecimalFormat df = new DecimalFormat("#.00");
            if(allOrders.size() > 0 ){
                try{
                    File file = new File("Orders.txt");
                    PrintWriter pw = new PrintWriter(file);
                    int orderNum = 0;
                    for(int i = 0 ; i < allOrders.size(); i++){
                        orderNum = i + 1;
                        pw.println("Order " + orderNum + " ");
                        pw.println("Total: $" + df.format(allOrders.get(i).getTotalPrice()));
                        pw.println(allOrders.get(i).toString());
                        pw.println();
                    }
                    pw.println("");
                    pw.close();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "File Exported");
                    alert.showAndWait();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "No orders to export");
                alert.showAndWait();
            }
        });

        /**
         *
         */
        cb_ordernum.setOnAction(event ->{
            Order selected;
            DecimalFormat df = new DecimalFormat("#.00");
            if(cb_ordernum.getItems().size() > 0 || cb_ordernum.getValue() != null){
                DecimalFormat d = new DecimalFormat("'$'0.00");
                if(!lv_storeorders.getItems().isEmpty()) lv_storeorders.getItems().clear();
                selected = controller.getStoreOrders().getStoreOrders().get(cb_ordernum.getValue()-1);
                lv_storeorders.getItems().addAll(selected.getOrder());
                tf_total.setText("$" + df.format(selected.getTotalPrice()));
            }
        });


    }

    /**
     *
     * @return
     */
    public ComboBox<Integer> getOrderNumber() {
        return cb_ordernum;
    }
}
