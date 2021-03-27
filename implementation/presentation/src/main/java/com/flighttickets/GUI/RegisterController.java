package com.flighttickets.GUI;

import com.flighttickets.App;
import com.flighttickets.BusinessLogic.CustomerImpl;
import com.flighttickets.Entities.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterController {
    Customer customerImpl;

    void RegisterController() {
        this.customerImpl = new CustomerImpl();
    }

    /**
     * First Name get from view
     */
    @FXML
    private Label firstNameLabel;

    @FXML
    private TextField firstNameTextBox;

    /**
     * Last Name get from view
     */
    @FXML
    private Label lastNameLabel;

    @FXML
    private TextField lastNameTextBox;

    /**
     * Email get from view
     */
    @FXML
    private Label emailLabel;

    @FXML
    private TextField emailTextBox;

    /**
     * Password get from view
     */
    @FXML
    private Label passwordLabel;

    @FXML
    private TextField passwordTextBox;

    /**
     * Address get from view
     */

    @FXML
    private Label addressLabel;

    @FXML
    private TextField addressTextBox;

    @FXML
    private Button registerButton;


    @FXML
    void handleRegister(ActionEvent event) throws IOException {
        this.customerImpl.
                App.setRoot("login");
    }

}
