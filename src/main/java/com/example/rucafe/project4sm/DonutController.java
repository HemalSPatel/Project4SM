package com.example.rucafe.project4sm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

import java.text.DecimalFormat;
import java.util.*;

public class DonutController {
    ObservableList<String> yeastf = FXCollections.observableArrayList("Jelly", "Glazed", "Chocolate Frost", "Strawberry Frost", "Powdered", "Maple Frost");
    ObservableList<String> cakef = FXCollections.observableArrayList("Old Fashion", "Cinnamon Sugar", "Blueberry");
    ObservableList<String> holef = FXCollections.observableArrayList("Sugar Coat", "Chocolate", "Butternut");
    private double subtotal = 0.0;
    //List<String> yeastflavor = ;
    @FXML private ComboBox<String> combo_donut_type;
    @FXML private ComboBox<Integer> combo_donut_num;
    @FXML private ListView<String> lv_donutflavor;
    @FXML private ListView<String> lv_donutpicked;
    @FXML private TextField tf_donutSub;
    @FXML private Button b_addDonutOrder; //Alert window
    @FXML private Button b_donutadd;
    @FXML private Button b_donutremove;
    @FXML private ImageView image_donut;

    private static ArrayList<Donut> donutOrder = new ArrayList<Donut>();

    public static ArrayList<Donut> getDonutOrder(){
        return donutOrder;
    }


    private Donut findDonut(String flavor){
        for(Donut e : donutOrder){
            if(e.getFlavor().equalsIgnoreCase(flavor)){
                return e;
            }
        }
        return null;
    }

//    public void initialize() {
//        combo_donut_type.setItems (FXCollections.observableArrayList("Yeast","Cake", "Donut Holes"));
//        combo_donut_num.setItems (FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
//        //combo_donut_type.setValue(combo_donut_type.getItems().get(0));
//        combo_donut_num.setValue(combo_donut_num.getItems().get(0));
//
//        combo_donut_type.setOnAction(event -> {
//            String selectedDonut = combo_donut_type.getValue();
//            // Image newImage = new Image(getClass().getResourceAsStream("com/example/rucafe/project4sm/images/Cake.png"));
//            //image_donut.setImage(newImage);
//            if (selectedDonut.equals("Yeast")) {
//                lv_donutflavor.getItems().clear();
//                lv_donutflavor.setItems(yeastf);
//            } else if (selectedDonut.equals("Cake")) {
//                lv_donutflavor.getItems().clear();
//                lv_donutflavor.setItems(cakef);
//            } else if (selectedDonut.equals("Donut Holes")) {
//                lv_donutflavor.getItems().clear();
//                lv_donutflavor.setItems(holef);
//            }
//        });
//
//        DecimalFormat df = new DecimalFormat("#.00");
//
//
//        b_donutadd.setOnAction(event -> {
//            String selectedItem = lv_donutflavor.getSelectionModel().getSelectedItem();
//            Integer selectedNum = combo_donut_num.getSelectionModel().getSelectedItem();
//            if(selectedItem != null) {
//                lv_donutflavor.getItems().remove(selectedItem);
//                String selectedDonut = combo_donut_type.getValue();
//                if (selectedDonut.equals("Yeast")) {
//                    yeastf = lv_donutflavor.getItems();
//                } else if (selectedDonut.equals("Cake")) {
//                    cakef = lv_donutflavor.getItems();
//                } else if (selectedDonut.equals("Donut Holes")) {
//                    holef = lv_donutflavor.getItems();
//                }
//                double price = 0.0;
//                switch(selectedDonut) {
//                    case "Yeast":
//                        price = 1.59;
//                        break;
//                    case "Cake":
//                        price = 1.79;
//                        break;
//                    case "Donut Holes":
//                        price = 0.39;
//                        break;
//                }
//
//                subtotal += selectedNum * price;
//                lv_donutpicked.getItems().add(selectedItem + " (" + selectedNum + ")");
//                tf_donutSub.setText("$" + df.format(subtotal));
//            }
//        });
//
//        b_donutremove.setOnAction(event -> {
//            String selectedItem = lv_donutpicked.getSelectionModel().getSelectedItem();
//            if(selectedItem != null) {
//                lv_donutpicked.getItems().remove(selectedItem);
//                String selectedDonut = combo_donut_type.getValue();
//
//                lv_donutflavor.getItems().add(selectedItem.substring(0, selectedItem.lastIndexOf("(") - 1));
//                double price = 0.0;
//                switch(selectedDonut) {
//                    case "Yeast":
//                        price = 1.59;
//                        break;
//                    case "Cake":
//                        price = 1.79;
//                        break;
//                    case "Donut Holes":
//                        price = 0.39;
//                        break;
//                }
//
//                int quantity = Integer.parseInt(selectedItem.substring(selectedItem.lastIndexOf("(") + 1, selectedItem.lastIndexOf(")")));
//                subtotal -= quantity * price;
//                tf_donutSub.setText("$" + df.format(subtotal));
//            }
//        });
//
//
//    }

//    Donut y1 = new Donut("Yeast", "Jelly");
//    Donut y2 = new Donut("Yeast", "Glazed");
//    Donut y3 = new Donut("Yeast", "Chocolate Frost");
//    Donut y4 = new Donut("Yeast", "Strawberry Frost");
//    Donut y5 = new Donut("Yeast", "Powdered");
//    Donut y6 = new Donut("Yeast", "Maple Frost");
//
public void initialize() {
    combo_donut_type.setItems(FXCollections.observableArrayList("Yeast", "Cake", "Donut Holes"));
    combo_donut_num.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
    combo_donut_num.setValue(combo_donut_num.getItems().get(0));

    Map<String, ObservableList<String>> donutFlavors = new HashMap<>();
    donutFlavors.put("Yeast", yeastf);
    donutFlavors.put("Cake", cakef);
    donutFlavors.put("Donut Holes", holef);


    combo_donut_type.setOnAction(event -> {
        String selectedDonut = combo_donut_type.getValue();
        if (selectedDonut != null) {
            lv_donutflavor.setItems(donutFlavors.get(selectedDonut));
            Image newImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/rucafe/project4sm/images/" + selectedDonut + ".png")));
            image_donut.setImage(newImage);
        }
    });

    DecimalFormat df = new DecimalFormat("#.00");

    b_donutadd.setOnAction(event -> {
        String selectedItem = lv_donutflavor.getSelectionModel().getSelectedItem();
        Integer selectedNum = combo_donut_num.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String selectedDonut = combo_donut_type.getValue();
            ObservableList<String> flavors = null;
            Donut addedDonut = new Donut(selectedDonut, selectedItem,selectedNum);
            donutOrder.add(addedDonut);
            switch (addedDonut.getType()) {
                case "Yeast":
                    flavors = FXCollections.observableArrayList(yeastf);
                    break;
                case "Cake":
                    flavors = FXCollections.observableArrayList(cakef);
                    break;
                case "Donut Holes":
                    flavors = FXCollections.observableArrayList(holef);
                    break;
            }
            flavors.remove(selectedItem);
            lv_donutflavor.setItems(flavors);
            lv_donutpicked.getItems().add(selectedItem + " (" + selectedNum + ")");
            subtotal += addedDonut.getAmount() * addedDonut.itemPrice();
            tf_donutSub.setText("$" + df.format(subtotal));
        }
    });


    b_donutremove.setOnAction(event -> {
        String selectedItem = lv_donutpicked.getSelectionModel().getSelectedItem();
        if(selectedItem != null) {
            lv_donutpicked.getItems().remove(selectedItem);
            String donutFlavor = selectedItem.substring(0, selectedItem.lastIndexOf("(") - 1);
            Donut removing = findDonut(donutFlavor);
            String selectedDonut = removing.getType();

            if (selectedDonut.equalsIgnoreCase("Yeast")) {
                yeastf.add(donutFlavor);
            } else if (selectedDonut.equalsIgnoreCase("Cake")) {
                cakef.add(donutFlavor);
            } else if (selectedDonut.equalsIgnoreCase("Donut Holes")) {
                holef.add(donutFlavor);
            }

            if (selectedDonut.equals(combo_donut_type.getValue())) {
                lv_donutflavor.getItems().add(donutFlavor);
            }
            int quantity = Integer.parseInt(selectedItem.substring(selectedItem.lastIndexOf("(") + 1, selectedItem.lastIndexOf(")")));
            subtotal -= quantity * removing.getPrice();
            tf_donutSub.setText("$" + df.format(subtotal));
            donutOrder.remove(removing);
        }
    });

    b_addDonutOrder.setOnAction(event -> {
        if (subtotal <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Your order has not been placed.");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Your order has been placed.");
            alert.showAndWait();

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("basket-view.fxml"));
                BorderPane root = (BorderPane) loader.load();
                BasketController basketcontroller = loader.getController();
                basketcontroller.setDonutController(this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    });

}



}



