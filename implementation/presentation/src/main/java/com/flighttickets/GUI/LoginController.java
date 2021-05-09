
package com.flighttickets.GUI;

import com.flighttickets.App;
//import com.flighttickets.BusinessLogic.LoginImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label emailLbl;

    @FXML
    private TextField emailTbx;

    @FXML
    private Label passwordLbl;

    @FXML
    private PasswordField passwordTbx;
    //TODO Type needs changing to password - jl

    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Label AccountTypeLbl;

    @FXML
    private ComboBox<String> AccountTypeCbx;

    @FXML
    void handleBack(ActionEvent event) throws IOException{
            App.setRoot("main");
    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        ObservableList<String> accountTypes = FXCollections.observableArrayList();
        accountTypes.addAll("Customer", "SalesOfficer", "Admin", "Planner");
        AccountTypeCbx.setItems(accountTypes);
    }

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        String userInpt = emailTbx.getText();
        String passInpt = passwordTbx.getText();
        /*LoginImpl login = new LoginImpl();

        if(login.getLoginLevel(userInpt, passInpt) == 2){
            App.setRoot("salesOfficer");
        } else if(login.getLoginLevel(userInpt, passInpt) == 1) {
            //TODO create customer main menu - jl
            App.setRoot("editTicket");
        } else {
            //TODO Implement wrong username error thrown in fxml - jl
            App.setRoot("main");
        }*/
    }

    @FXML
    void handleRegister(ActionEvent event) throws IOException {
        App.setRoot("register");
    }
}

