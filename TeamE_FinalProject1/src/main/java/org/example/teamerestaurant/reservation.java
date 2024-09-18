package org.example.teamerestaurant;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class reservation {
    public void openReservationGUI() throws IOException {
        Stage reservationstage = new Stage();
        FXMLLoader reservationfxmlLoader = new FXMLLoader(mainGUIController.class.getResource("reservationView.fxml"));
        Scene reservationscene = new Scene(reservationfxmlLoader.load(),500,450);
        reservationstage.setTitle("reservations");
        reservationstage.setScene(reservationscene);
        reservationstage.show();
    }
    savedReservationInfo openReservationSave = new savedReservationInfo();

    @FXML
    protected void onReserveButtonClick() throws IOException {
        LocalDate selectedDate = ReservationDate.getValue();
        String nameInput = Name.getText();
        String timeInput = ReservationTime.getText();
        String sizeInput = ReservationSize.getText();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("reservationInfoSave"))){
            writer.write(nameInput+"\n");
            writer.write(timeInput+"\n");
            writer.write(selectedDate+"\n");
            writer.write(sizeInput+"\n");
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        openReservationSave.openSavedReservationInfoGUI();

    }



    @FXML
    private TextField Name;
    @FXML
    private TextField ReservationTime;
    @FXML
    private DatePicker ReservationDate;
    @FXML
    private TextField ReservationSize;


}

