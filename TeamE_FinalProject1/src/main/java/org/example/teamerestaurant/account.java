package org.example.teamerestaurant;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class account {
    public String User;
    public String Pass;


    public void openAccountGUI() throws IOException {
        Stage accountstage = new Stage();
        FXMLLoader accountfxmlLoader = new FXMLLoader(mainGUIController.class.getResource("accountView.fxml"));
        Scene accountscene = new Scene(accountfxmlLoader.load(), 500, 450);
        accountstage.setTitle("account");
        accountstage.setScene(accountscene);
        accountstage.show();
    }

    @FXML
    private TextField username;
    @FXML
    private TextField password;

    public void initialize() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("registerAccountSave"));
        User = lines.get(0);
        Pass = lines.get(1);
    }


    RegisterAccount openRegister = new RegisterAccount();

    @FXML
    protected void onRegisterButtonClick() throws IOException {
        openRegister.openRegisterAccountGUI();
        Stage stage = (Stage) username.getScene().getWindow();
        stage.close();
    }


    menuOrder openMenuOrder = new menuOrder();

    @FXML
    protected void onLoginButtonClick() throws IOException {
        try {
            String userInput = username.getText();

            String passInput = password.getText();
            if (!(userInput.equals(User) && passInput.equals(Pass))) {
                throw new IllegalArgumentException("Incorrect Username or Password. Try Again");
            }
            Stage stage = (Stage) username.getScene().getWindow();
            stage.close();
            openMenuOrder.openMenuOrderGUI();
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
