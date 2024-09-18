package org.example.teamerestaurant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class mainGUIController extends Application {
    @Override
    public void start(Stage homestage) throws IOException {
        FXMLLoader homefxmlLoader = new FXMLLoader(mainGUIController.class.getResource("homeView.fxml"));
        Scene homescene = new Scene(homefxmlLoader.load(), 500, 450);
        homestage.setTitle("Restaurant");
        homestage.setScene(homescene);
        homestage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}