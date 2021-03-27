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
    private Label usernameLabel;

    @FXML
    private TextField usernameTextBox;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField passwordTextBox;

    @FXML
    private Button registerButton;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField emailTextBox;

    @FXML
    private Label addressLabel;

    @FXML
    private TextField addressTextBox;

    @FXML
    void handleRegister(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

}
