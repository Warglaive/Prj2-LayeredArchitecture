package com.flighttickets;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private Label usernameLbl;

    @FXML
    private TextField usernameTbx;

    @FXML
    private Label passwordLbl;

    @FXML
    private TextField passwordTbx;

    @FXML
    private Button loginBtn;

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        App.setRoot("salesOfficer");
    }

}
