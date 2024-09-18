package org.example.teamerestaurant;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterAccount {

    public void openRegisterAccountGUI() throws IOException {
        Stage Registerstage = new Stage();
        FXMLLoader RegisterfxmlLoader = new FXMLLoader(mainGUIController.class.getResource("RegisterAccountView.fxml"));
        Scene Registerscene = new Scene(RegisterfxmlLoader.load(), 500, 450);
        Registerstage.setTitle("Register Account");
        Registerstage.setScene(Registerscene);
        Registerstage.show();
    }

    @FXML
    private TextField username;
    @FXML
    private TextField password;


    @FXML
    protected void onRegisterButtonClick(){
    try{
        String userInput = username.getText();
        String passInput = password.getText();
        if (passInput.isEmpty() || userInput.isEmpty()){
            throw new IllegalArgumentException("Invalid User Input. Check If All Fields Are Filled Out.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("registerAccountSave"))){
            writer.write(userInput+"\n");
            writer.write(passInput+"\n");
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = (Stage) username.getScene().getWindow();
        stage.close();
//need to close account sign in to work - force it to update txt
    } catch (IllegalArgumentException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Input Error");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }

    }


    }

