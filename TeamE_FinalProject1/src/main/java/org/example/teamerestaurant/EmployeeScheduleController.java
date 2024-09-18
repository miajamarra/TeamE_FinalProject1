package org.example.teamerestaurant;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeScheduleController{
public void openEmployeeSchedule
        () throws IOException {
    Stage EmployeeSchedulestage= new Stage();
    FXMLLoader EmployeeSchedulefxmlLoader = new FXMLLoader(mainGUIController.class.getResource("EmployeeSchedule.fxml"));
    Scene EmployeeSchedulescene = new Scene(EmployeeSchedulefxmlLoader.load(), 660, 258);
    EmployeeSchedulestage.setTitle("Employee Schedule");
    EmployeeSchedulestage.setScene(EmployeeSchedulescene);
    EmployeeSchedulestage.show();

}
}