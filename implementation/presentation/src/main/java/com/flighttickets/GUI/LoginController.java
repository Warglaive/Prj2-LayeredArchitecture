package com.flighttickets.GUI;

import com.flighttickets.App;
import com.flighttickets.BusinessLogic.CustomerImpl;
import com.flighttickets.BusinessLogic.LoginImpl;
import com.flighttickets.Entities.Customer;
import com.flighttickets.Persistance.RegisteredUsers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class LoginController {

    @FXML
    private Label emailLbl;

    @FXML
    private TextField emailTbx;

    @FXML
    private Label passwordLbl;

    @FXML
    private TextField passwordTbx;
    //TODO Type needs changing to password - jl

    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    private Button backBtn;

    @FXML
    void handleBack(ActionEvent event) throws IOException{
            App.setRoot("main");
    }

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        String userInpt = emailTbx.getText();
        //TODO email validation
        String passInpt = passwordTbx.getText();
        LoginImpl login = new LoginImpl();
        System.out.println(login.getLoginLevel(userInpt, passInpt));

        if(login.getLoginLevel(userInpt, passInpt) == 2){
            App.setRoot("salesOfficer");
        } else if(login.getLoginLevel(userInpt, passInpt) == 1) {
            //TODO create customer main menu - jl
            App.setRoot("editTicket");
        } else {
            //TODO Implement wrong username error thrown in fxml - jl
            App.setRoot("main");
        }
    }

    @FXML
    void handleRegister(ActionEvent event) throws IOException {
        App.setRoot("register");
    }
}
