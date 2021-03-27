package com.flighttickets.GUI;

import com.flighttickets.App;
import com.flighttickets.BusinessLogic.CustomerImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterController {
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

    /**
     * Button to provide ActionEvent on click
     */
    @FXML
    private Button registerButton;


    @FXML
    void handleRegister(ActionEvent event) throws IOException {
        //Get values from textBoxes
        String firstName = firstNameTextBox.getText();
        String lastName = lastNameTextBox.getText();
        String email = emailTextBox.getText();
        String password = passwordTextBox.getText();
        String address = addressTextBox.getText();

        //register new Customer
        CustomerImpl customer = new CustomerImpl(firstName, lastName, email, password, address);
        //send customer to Login view
        App.setRoot("login");
    }

}
