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

public class onlineOrderInfoPT2 {
    public void openOnlineOrderPt2GUI() throws IOException {
        Stage orderAddressstage = new Stage();
        FXMLLoader orderAddressfxmlLoader = new FXMLLoader(mainGUIController.class.getResource("onlineOrderInfoViewPT2.fxml"));
        Scene orderAddressscene = new Scene(orderAddressfxmlLoader.load(),500,450);
        orderAddressstage.setTitle("address info");
        orderAddressstage.setScene(orderAddressscene);
        orderAddressstage.show();
    }
    @FXML
    private TextField zipCode;
    @FXML
    private TextField streetAddress;
    @FXML
    private TextField town;
    @FXML
    private TextField state;
savedOrderInfo savedInfo = new savedOrderInfo();
    @FXML
    protected void onSaveButtonClick() throws IOException {
        try{
            String zipInput = zipCode.getText();
            String streetInput = streetAddress.getText();
            String townInput = town.getText();
            String stateInput = state.getText();

            if (zipInput.isEmpty() || zipInput.length()<4 || zipInput.length()>10 || streetInput.isEmpty() || townInput.isEmpty() ||
                    stateInput.isEmpty()) {
                throw new IllegalArgumentException("Invalid User Input. Check If All Fields Are Filled Out.");
            }else {

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("onlineOrderInfoSavePT2"))) {
                    writer.write("Zip Code: " + zipInput + "\n");
                    writer.write("Street Address: " + streetInput + "\n");
                    writer.write("Town Name: " + townInput + "\n");
                    writer.write("State: " + stateInput + "\n");
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                savedInfo.openSavedOrderInfoGUI();
            }
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

}
