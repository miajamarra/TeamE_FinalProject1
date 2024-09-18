package org.example.teamerestaurant;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class savedOrderInfo {

        @FXML
        private Label onlineOrderPT1Info = new Label();
        @FXML
        private Label onlineOrderPT2Info = new Label();
        public void initialize(){
                readOnlineOrderInfoPT1();
                readOnlineOrderInfoPT2();
        }
        public void readOnlineOrderInfoPT1() {
                try {
                        String content = new String(Files.readAllBytes(Paths.get("onlineOrderInfoSavePT1")));
                        onlineOrderPT1Info.setText(content);
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        public void readOnlineOrderInfoPT2() {
                try {
                        String content2 = new String(Files.readAllBytes(Paths.get("onlineOrderInfoSavePT2")));
                        onlineOrderPT2Info.setText(content2);
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        public void openSavedOrderInfoGUI() throws IOException {
                Stage savedOrderInfostage = new Stage();
                FXMLLoader savedOrderInfofxmlLoader = new FXMLLoader(mainGUIController.class.getResource
                        ("savedOrderInfoView.fxml"));
                Scene savedOrderInfoscene = new Scene(savedOrderInfofxmlLoader.load(), 500, 450);
                savedOrderInfostage.setTitle("saved order info");
                savedOrderInfostage.setScene(savedOrderInfoscene);
                savedOrderInfostage.show();
                readOnlineOrderInfoPT1();
                readOnlineOrderInfoPT2();
        }
}


