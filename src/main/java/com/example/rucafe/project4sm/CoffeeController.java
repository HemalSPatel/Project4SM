package com.example.rucafe.project4sm;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class CoffeeController {
    private final int MAX_SELECTIONS = 2;
    private int numSelections = 0;
    double subtotal =0;

    private List<CheckBox> selectedCheckboxes = new ArrayList<>();
    @FXML private ComboBox<Integer> num_coffee;
    @FXML private ComboBox<String> coffee_size;
    @FXML private TextField coffee_subtotal;
    @FXML private Button coffee_add;
    @FXML private CheckBox cb_SC;
    @FXML private CheckBox cb_FV;
    @FXML private CheckBox cb_IC;
    @FXML private CheckBox cb_Mocha;
    @FXML private CheckBox cb_Caramel;

    private double basePrice = 1.89;
    private double sizePriceIncrement = 0.4;
    private double addInPrice = 0.3;

    public void initialize() {
        num_coffee.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
        coffee_size.setItems(FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti"));

        cb_SC.setOnAction(e -> handleCheckboxSelection(cb_SC));
        cb_FV.setOnAction(e -> handleCheckboxSelection(cb_FV));
        cb_IC.setOnAction(e -> handleCheckboxSelection(cb_IC));
        cb_Mocha.setOnAction(e -> handleCheckboxSelection(cb_Mocha));
        cb_Caramel.setOnAction(e -> handleCheckboxSelection(cb_Caramel));

        coffee_add.setOnAction(event -> {
            if (subtotal <= 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Your order has not been placed.");
                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Your order has been placed.");
                alert.showAndWait();
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("coffee-view.fxml"));
                    BorderPane roots = (BorderPane) loader.load();
                    BasketController basketcontroller = loader.getController();
                    basketcontroller.setCoffeeController(this);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        num_coffee.setOnAction(e -> updateSubtotal());
        coffee_size.setOnAction(e -> updateSubtotal());


    }

    private void handleCheckboxSelection(CheckBox checkbox) {
        if (checkbox.isSelected()) {
            if (selectedCheckboxes.size() >= MAX_SELECTIONS) {
                checkbox.setSelected(false);
            } else {
                selectedCheckboxes.add(checkbox);
            }
        } else {
            selectedCheckboxes.remove(checkbox);
        }

        updateSubtotal();
    }

    private void handleCoffeeAdd() {
        updateSubtotal();
    }

    private void updateSubtotal() {
        int numCups = num_coffee.getValue() == null ? 0 : num_coffee.getValue();
        String sizeStr = coffee_size.getValue();
        double sizePrice = 0.0;

        if (sizeStr != null) {
            switch (sizeStr) {
                case "Tall":
                    sizePrice = sizePriceIncrement;
                    break;
                case "Grande":
                    sizePrice = sizePriceIncrement * 2;
                    break;
                case "Venti":
                    sizePrice = sizePriceIncrement * 3;
                    break;
                default:
                    // Short has base price 0, no need to add anything
                    break;
            }
        }

        double addInPriceTotal = selectedCheckboxes.size() * addInPrice;
        subtotal = (basePrice + sizePrice + addInPriceTotal) * numCups;
        coffee_subtotal.setText(String.format("%.2f", subtotal));
    }
}

