package com.example.rucafe.project4sm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Controller class for the donut fxml file to allow the program to react to
 * user interactions
 * @author Hemal Patel, Ishika Patel
 */
public class DonutController {
    ObservableList<String> yeastf = FXCollections.observableArrayList("Jelly", "Glazed", "Chocolate Frost", "Strawberry Frost", "Powdered", "Maple Frost");
    ObservableList<String> cakef = FXCollections.observableArrayList("Old Fashion", "Cinnamon Sugar", "Blueberry");
    ObservableList<String> holef = FXCollections.observableArrayList("Sugar Coat", "Chocolate", "Butternut");
    private double subtotal = 0.0;
    DecimalFormat df = new DecimalFormat("#.00");
    @FXML private ComboBox<String> combo_donut_type;
    @FXML private ComboBox<Integer> combo_donut_num;
    @FXML private ListView<String> lv_donutflavor;
    @FXML private ListView<String> lv_donutpicked;
    @FXML private TextField tf_donutSub;
    @FXML private Button b_addDonutOrder; //Alert window
    @FXML private Button b_donutadd;
    @FXML private Button b_donutremove;
    @FXML private ImageView image_donut;
    private RUCafeController controller;
    private static ArrayList<Donut> donutOrder = new ArrayList<Donut>();

    /**
     * Sets the main controller for this controller.
     * @param controller main controller.
     */
    public void setMainController(RUCafeController controller){
        this.controller = controller;
    }

    /**
     * resets the arraylist of the temporary donut order to null if it already isn't
     */
    public static void resetOrderDonut(){
        if(donutOrder != null){
            donutOrder.clear();
        }
    }

    /**
     * finds the donut object in the array list based on the flavor given
     * @param flavor
     * @return donut object of that falvor
     */
    private Donut findDonut(String flavor){
        for(Donut e : donutOrder){
            if(e.getFlavor().equalsIgnoreCase(flavor)){
                return e;
            }
        }
        return null;
    }

    /**
     * contains all the set on action types for the UI
     */
    public void initialize() {
        combo_donut_type.setItems(FXCollections.observableArrayList("Yeast", "Cake", "Donut Holes"));
        combo_donut_num.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        combo_donut_num.setValue(combo_donut_num.getItems().get(0));

        Map<String, ObservableList<String>> donutFlavors = new HashMap<>();
        donutFlavors.put("Yeast", yeastf);
        donutFlavors.put("Cake", cakef);
        donutFlavors.put("Donut Holes", holef);

        /**
         * Changes the list of flavors of donuts based on what type of donut is selected
         */
        combo_donut_type.setOnAction(event -> {
            String selectedDonut = combo_donut_type.getValue();
            if (selectedDonut != null) {
                lv_donutflavor.setItems(donutFlavors.get(selectedDonut));
                Image newImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/rucafe/project4sm/images/" + selectedDonut + ".png")));
                image_donut.setImage(newImage);
            }
        });

        /**
         * Creates a donut object to add to the right side list so that the user
         * knows what is in their temporary order
         */
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
                Donut removing = findDonut(selectedItem);
                String sDonut = removing.getType();
                if (sDonut.equalsIgnoreCase("Yeast")) {
                    yeastf.remove(selectedItem);
                } else if (sDonut.equalsIgnoreCase("Cake")) {
                    cakef.remove(selectedItem);
                } else if (sDonut.equalsIgnoreCase("Donut Holes")) {
                    holef.remove(selectedItem);
                }
            }
        });

        /**
         * removes the selected donut from the right side list when the remove button is clicked
         */
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

        /**
         * adds the temporary donut order to the cart and alerts the user of their status
         */
        b_addDonutOrder.setOnAction(event -> {
            if (subtotal <= 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Your order has not been placed.");
                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Your order has been placed.");
                alert.showAndWait();
                for(int i = 0; i < donutOrder.size(); i++){
                    controller.addToOrder(donutOrder.get(i));
                }
                donutOrder.clear();
                tf_donutSub.setText("$0.00");
                lv_donutpicked.getItems().removeAll(lv_donutpicked.getItems());
                }
        });

    }

}


