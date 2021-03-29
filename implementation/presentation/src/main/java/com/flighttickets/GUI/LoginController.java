package com.flighttickets.GUI;

import com.flighttickets.App;
import com.flighttickets.BusinessLogic.CustomerImpl;
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
    //TODO Type needs changing to password - jl

    @FXML
    private Button loginBtn;

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        String user = usernameTbx.getText();
        String passw = passwordTbx.getText();
        if(user.equals("admin") && passw.equals("admin")){
            App.setRoot("salesOfficer");
        } else if(user.equals("customer") && passw.equals("customer")) {
            //TODO create customer main menu - jl
            App.setRoot("editTicket");
        } else {
            //TODO Implement wrong username error thrown in fxml - jl
            App.setRoot("login");
        }
    }

}
