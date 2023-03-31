package com.example.rucafe.project4sm;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoffeeController {
    private final int MAX_SELECTIONS = 2;
    private int numSelections = 0;
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
    public void initialize() {
        num_coffee.setItems (FXCollections.observableArrayList(1, 2, 3, 4, 5));
        coffee_size.setItems (FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti"));

        cb_SC.setOnAction(e -> handleCheckboxSelection(cb_SC));
        cb_FV.setOnAction(e -> handleCheckboxSelection(cb_FV));
        cb_IC.setOnAction(e -> handleCheckboxSelection(cb_IC));
        cb_Mocha.setOnAction(e -> handleCheckboxSelection(cb_Mocha));
        cb_Caramel.setOnAction(e -> handleCheckboxSelection(cb_Caramel));

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

        if (selectedCheckboxes.size() >= MAX_SELECTIONS) {
            for (CheckBox cb : Arrays.asList(cb_SC, cb_FV, cb_IC, cb_Mocha, cb_Caramel)) {
                if (!cb.isSelected()) {
                    cb.setDisable(true);
                }
            }
        } else {
            for (CheckBox cb : Arrays.asList(cb_SC, cb_FV, cb_IC, cb_Mocha, cb_Caramel)) {
                cb.setDisable(false);
            }
        }
    }

}
