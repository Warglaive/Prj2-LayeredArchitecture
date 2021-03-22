package com.flighttickets;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    void showLogin(ActionEvent event) throws IOException{
        App.setRoot("login");
    }

    @FXML
    void showRegister(ActionEvent event) throws IOException {
        App.setRoot("register");
    }

}
