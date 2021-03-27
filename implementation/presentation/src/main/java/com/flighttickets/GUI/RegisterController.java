package com.flighttickets.GUI;

import com.flighttickets.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterController {

    @FXML
    private Label usernameLbl;

    @FXML
    private TextField usernameTbx;

    @FXML
    private Label passwordLbl;

    @FXML
    private TextField passwordTbx;

    @FXML
    private Button registerBtn;

    @FXML
    private Label emailLbl;

    @FXML
    private TextField emailTbx;

    @FXML
    private Label addressLbl;

    @FXML
    private TextField addressTbx;

    @FXML
    void handleRegister(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

}
