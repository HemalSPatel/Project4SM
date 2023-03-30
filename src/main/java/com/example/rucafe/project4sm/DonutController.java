package com.example.rucafe.project4sm;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class DonutController {
    @FXML private ComboBox<String> combo_donut_type;
    @FXML private ComboBox<Integer> combo_donut_num;
    public void initialize() {
        combo_donut_type.setItems (FXCollections.observableArrayList("Yeast","Cake", "Donut Holes"));
        combo_donut_num.setItems (FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
    }
}
