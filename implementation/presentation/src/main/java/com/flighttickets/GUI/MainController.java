package com.flighttickets.GUI;

import java.io.IOException;

import com.flighttickets.GUIApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    void showLogin(ActionEvent event) throws IOException {
        GUIApp.setRoot("login");
    }

    @FXML
    void showRegister(ActionEvent event) throws IOException {
        GUIApp.setRoot("register");
    }

}
