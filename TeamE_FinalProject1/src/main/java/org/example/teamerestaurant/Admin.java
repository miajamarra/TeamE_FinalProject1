package org.example.teamerestaurant;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Admin {

    EmployeeScheduleController scheduleOpen = new EmployeeScheduleController();
    public String passWord;

    public void initialize() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("adminLogin"));
        passWord = lines.get(0);
    }
    public void openAdminLoginGUI() throws IOException {
        Stage adminLoginStage = new Stage();
        FXMLLoader adminLoginfxmlLoader = new FXMLLoader(mainGUIController.class.getResource("adminLoginView.fxml"));
        Scene adminLoginscene = new Scene(adminLoginfxmlLoader.load(),300,300);
        adminLoginStage.setTitle("Admin Login");
        adminLoginStage.setScene(adminLoginscene);
        adminLoginStage.show();
    }


    @FXML
    private PasswordField passWordInput;





    @FXML
    protected void onLoginButtonClick() throws IOException {
        try {
            String passwordInput = passWordInput.getText();
            if (!passwordInput.equals(passWord)) {
                throw new IllegalArgumentException("Incorrect Username or Password. Try Again");
            }
            scheduleOpen.openEmployeeSchedule();
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }


}
