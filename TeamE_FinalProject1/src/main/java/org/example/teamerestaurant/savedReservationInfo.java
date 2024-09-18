package org.example.teamerestaurant;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class savedReservationInfo {
    @FXML
    private TextField Name;
    @FXML
    private TextField ReservationTime;
    @FXML
    private TextField ReservationDate;
    @FXML
    private TextField ReservationSize;
    public void  initialize() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("reservationInfoSave"));
            String nameLine = lines.get(0);
            String timeLine = lines.get(1);
            String dateLine = lines.get(2);
            String sizeLine = lines.get(3);
            Name.setText(nameLine);
            ReservationTime.setText(timeLine);
            ReservationDate.setText(dateLine);
            ReservationSize.setText(sizeLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openSavedReservationInfoGUI() throws IOException {
        Stage savedReservationInfoStage = new Stage();
        FXMLLoader savedReservationInfoFxmlLoader = new FXMLLoader(mainGUIController.class.getResource("savedReservationInfoView.fxml"));
        Scene savedReservationInfoScene = new Scene(savedReservationInfoFxmlLoader.load(), 500, 450);
        savedReservationInfoStage.setTitle("Saved Reservation Info");
        savedReservationInfoStage.setScene(savedReservationInfoScene);
        savedReservationInfoStage.show();
    }
}
