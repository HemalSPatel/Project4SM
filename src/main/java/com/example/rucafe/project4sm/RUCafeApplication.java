package com.example.rucafe.project4sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * application class for the entire project
 * and it launches the application
 * @author Hemal Patel, Ishika Patel
 */
public class RUCafeApplication extends Application {
    @Override
    /**
     * starts the application with the first fxml file view
     */
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RUCafeApplication.class.getResource("rucafe-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("RU Cafe");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}