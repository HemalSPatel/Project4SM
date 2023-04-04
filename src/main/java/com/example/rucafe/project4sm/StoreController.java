package com.example.rucafe.project4sm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StoreController {
    @FXML
    private Button b_cancel;
    @FXML
    private Button b_export;
    @FXML
    private ComboBox<?> cb_ordernum;
    @FXML
    private ListView<?> lv_orders;
    @FXML
    private TextField tf_total;
    private BasketController basketController;
    public void setBasketController(BasketController Controller) {
        basketController = Controller;
    }

    private ArrayList<Order> allOrders;
    private static int orderNum = 0;

    private void resetCombo(ArrayList<Order> allOrders){
        int j;
        for(int i = 0; i < allOrders.size(); i++){
            j = i+1;
            //cb_ordernum.getItems().add(i, (j));
        }
    }

    public void initialize() {
        allOrders = new ArrayList<>();
        Order currentOrder = new Order(orderNum++, basketController.getOrder());
        allOrders.add(currentOrder);

        b_cancel.setOnAction(event -> {
            int selectedID = lv_orders.getSelectionModel().getSelectedIndex();
            allOrders.remove(selectedID);
            lv_orders.getItems().remove(selectedID);
        });

        b_export.setOnAction(event -> {
            if(allOrders.size() >0 ){
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
                }catch (IOException e){
                    e.printStackTrace();
                }
            }else{
            }
        });

        cb_ordernum.setOnAction(event ->{

        });


    }
}
