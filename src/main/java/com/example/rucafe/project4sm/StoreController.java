package com.example.rucafe.project4sm;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

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
    private BasketController basketController;

    private RUCafeController controller;

    /**
     * Sets the main controller for this controller.
     * @param controller main controller.
     */
    public void setMainController(RUCafeController controller){
        this.controller = controller;
    }
    public void setBasketController(BasketController Controller) {
        basketController = Controller;
    }

    public static ArrayList<Order> allOrders;
    private static int orderNum = 0;

    private void resetCombo(ArrayList<Order> allOrders){
        int j;
        if(allOrders.size() > 0){
            for(int i = 0; i < allOrders.size(); i++){
                cb_ordernum.getItems().add(i + 1);
            }
        }
    }

    public void initialize() {
        //allOrders = new ArrayList<Order>();
        //Order currentOrder = new Order(basketController.getOrder());
        //basketController.resetOrder();
        //allOrders.add(currentOrder);
        //lv_orders.getItems().addAll(currentOrder);
        try {
            resetCombo(allOrders);
        }catch (Exception e) {

        }


        b_cancel.setOnAction(event -> {
//            int selectedNum = (int) cb_ordernum.getValue();
//            lv_storeorders.getItems().clear();
//            allOrders.remove(selectedNum-1);
//            resetCombo(allOrders);
//            tf_total.setText("$0.00");
            int remove = cb_ordernum.getSelectionModel().getSelectedIndex();
            lv_storeorders.getItems().clear();
            //total.setText("$0.00");
            if(remove >= 0) {
                controller.removeFromStoreOrder(controller.getStoreOrders().getStoreOrders().get(remove));
                cb_ordernum.getItems().removeAll(cb_ordernum.getItems());
                for(int i = 0; i < controller.getStoreOrders().getStoreOrders().size(); i ++){
                    cb_ordernum.getItems().add(i+1);
                }
            }
        });

        b_export.setOnAction(event -> {
            if(allOrders.size() > 0 ){
                try{
                    File file = new File("Orders.txt");
                    PrintWriter pw = new PrintWriter(file);
                    for(int i = 0 ; i < allOrders.size(); i++){
                        pw.println("Order " + i+1);
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

        cb_ordernum.setOnAction(event ->{
//            int selectedNum = (int) cb_ordernum.getValue();
//            DecimalFormat df = new DecimalFormat("#.00");
//            ArrayList<MenuItem> cur = allOrders.get(selectedNum - 1).getItems();
//            double total = 0;
//            if (selectedNum != 0) {
//                for(MenuItem w : cur){
//                    if(w != null){
//                        total += (w.getAmount()* w.itemPrice());
//                        lv_orders.getItems().add(w.toString());
//                    }
//                }
//                tf_total.setText("$" + df.format(total));
//            }
            if(cb_ordernum.getItems().size() > 0 || cb_ordernum.getValue() != null){
                DecimalFormat d = new DecimalFormat("'$'0.00");
                if(!lv_storeorders.getItems().isEmpty()) lv_storeorders.getItems().clear();
                lv_storeorders.getItems().addAll(controller.getStoreOrders().getStoreOrders().get(cb_ordernum.getValue()-1).getOrder());
                //total.setText(""+ d.format(controller.getStoreOrders().getStoreOrders().get(cb_ordernum.getValue()-1).getTotal()));
            }
        });


    }

    public ComboBox<Integer> getOrderNumber() {
        return cb_ordernum;
    }
}
