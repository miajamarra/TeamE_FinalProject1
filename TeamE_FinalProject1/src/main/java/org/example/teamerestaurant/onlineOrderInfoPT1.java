package org.example.teamerestaurant;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class onlineOrderInfoPT1 {

    public void initialize() {
        cardBrand.getItems().removeAll(cardBrand.getItems());
        cardBrand.getItems().addAll("MasterCard", "Visa", "American Express", "Discover");
        cardBrand.getSelectionModel().select("Visa");
    }

    public void openOnlineOrderGUI() throws IOException {
        Stage orderInfostage = new Stage();
        FXMLLoader orderInfofxmlLoader = new FXMLLoader(mainGUIController.class.getResource("onlineOrderInfoViewPT1.fxml"));
        Scene orderInfoscene = new Scene(orderInfofxmlLoader.load(),500, 450);
        orderInfostage.setTitle("order info");
        orderInfostage.setScene(orderInfoscene);
        orderInfostage.show();
    }
    onlineOrderInfoPT2 openAddressInfoGUI = new onlineOrderInfoPT2();

    @FXML
    private ChoiceBox<String> cardBrand;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField billingAddress;
    @FXML
    private TextField cardNumber;
    @FXML
    private TextField expYear;
    @FXML
    private TextField expMonth;
    @FXML
    private TextField securityNum;


    @FXML
    protected void onContinueButtonClick() {
        try {
            openAddressInfoGUI.openOnlineOrderPt2GUI();
            String firstInput = firstName.getText();
            String lastInput = lastName.getText();
            String phoneInput = phoneNumber.getText();
            String billingInput = billingAddress.getText();
            String cardInput = cardNumber.getText();
            int yearInput = Integer.parseInt(expYear.getText());
            int monthInput = Integer.parseInt(expMonth.getText());
            String securityInput = securityNum.getText();

            cardInfo cardInformation = new cardInfo();
            String cardResponse = cardInformation.returnNumberOutput(cardInput);
            String expirationResponse = cardInfo.returnExpirationOutput(yearInput, monthInput);
            String securityResponse = cardInfo.returnSecurityOutput(securityInput);
            //write into a popup or a field

            if (firstInput.isEmpty() || lastInput.isEmpty() || phoneInput.isEmpty() ||
                    billingInput.isEmpty() || cardInput.isEmpty() || securityInput.isEmpty()) {
                throw new IllegalArgumentException("Invalid User Input. Check If All Fields Are Filled Out.");
            }else {
                if(cardResponse.contains("Invalid credit card number.") || expirationResponse.contains("Invalid or null credit card security number") || securityResponse.contains("Invalid credit card security number.")){
                    throw new IllegalArgumentException("Please check, you may have an invalid credit card number, expiration date or security code.");
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("onlineOrderInfoSavePT1"))) {
                writer.write("First Name: " + firstInput + "\n");
                writer.write("Last Name: " + lastInput + "\n");
                writer.write("Phone Number: " + phoneInput + "\n");
                writer.write("Billing Address: " + billingInput + "\n");
                writer.write("Card Number: " + cardInput + "\n");
                writer.write("Expiration Year: " + yearInput + "\n");
                writer.write("Expirations Month: " + monthInput + "\n");
                writer.write("Security Number: " + securityInput + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Input Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("IO Error");
            alert.setContentText("An error occurred while opening the next GUI.");
            alert.showAndWait();
        }
    }
    }
