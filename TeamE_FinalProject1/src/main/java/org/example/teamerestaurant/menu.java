package org.example.teamerestaurant;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class menu {
    public void openMenuGUI() throws IOException {
        Stage menustage = new Stage();
        FXMLLoader menufxmlLoader = new FXMLLoader(mainGUIController.class.getResource("menuViewPage.fxml"));
        Scene menuscene = new Scene(menufxmlLoader.load(),500,700);
        menustage.setTitle("menu");
        menustage.setScene(menuscene);
        menustage.show();
    }
}
