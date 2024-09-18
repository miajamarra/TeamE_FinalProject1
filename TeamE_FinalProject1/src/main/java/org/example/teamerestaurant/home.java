package org.example.teamerestaurant;

import javafx.fxml.FXML;

import java.io.IOException;

public class home {

    menu openMenu = new menu();
    menuOrder openOrders = new menuOrder();
    account openAccount = new account();
    Admin openAdmin = new Admin();
    reservation openReservations = new reservation();


    @FXML
    protected void onMenuButtonClick() throws IOException {openMenu.openMenuGUI();
    }
    @FXML
    protected  void onOrderButtonClick() throws IOException {openOrders.openMenuOrderGUI();
    }
    @FXML
    protected void onAccountButtonClick() throws IOException {openAccount.openAccountGUI();
    }
    @FXML
    protected void onReservationButtonClick() throws IOException {
        openReservations.openReservationGUI();
    }
    @FXML
    protected void onAdminButtonClick() throws IOException{
        openAdmin.openAdminLoginGUI();
    }
    }
