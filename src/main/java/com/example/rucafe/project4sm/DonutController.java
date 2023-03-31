package com.example.rucafe.project4sm;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DonutController {
    @FXML private ComboBox<String> combo_donut_type;
    @FXML private ComboBox<Integer> combo_donut_num;

    @FXML private ImageView image_donut;
    public void initialize() {
        combo_donut_type.setItems (FXCollections.observableArrayList("Yeast","Cake", "Donut Holes"));
        combo_donut_num.setItems (FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));

        combo_donut_type.setOnAction(event -> {
            String selectedDonut = combo_donut_type.getValue();
            Image newImage = new Image(getClass().getResourceAsStream("com/example/rucafe/project4sm/images/Cake.png"));
            image_donut.setImage(newImage);
        });

    }
}
