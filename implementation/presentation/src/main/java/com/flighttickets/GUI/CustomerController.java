package com.flighttickets.GUI;

import com.flighttickets.App;
import com.flighttickets.BusinessLogic.BusinessLogicAPIImpl;
import com.flighttickets.BusinessLogic.CustomerImpl;
import com.flighttickets.BusinessLogic.CustomerManagerImpl;
import com.flighttickets.BusinessLogic.LoginImpl;
import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageServiceImpl;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceAPIImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CustomerController {
    @FXML
    private Label firstNameLabel;

    @FXML
    private TextField firstNameTextBox;

    @FXML
    private Label lastNameLabel;

    @FXML
    private TextField lastNameTextBox;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField emailTextBox;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField passwordTextBox;

    @FXML
    private Label addressLabel;

    @FXML
    private TextField addressTextBox;

    @FXML
    private Button registerButton;
    @FXML
    private Button backBtn;

    @FXML
    private Button submitButton;

    @FXML
    void backBtnHandler(ActionEvent event) throws IOException {
        App.setRoot("main");
    }

    /**
     * CustomerManager - register/login and other customer ops.
     */
    CustomerManager customerManager;

    BusinessLogicAPIImpl businessLogicAPI;
    PersistenceAPI persistenceAPI;

    public CustomerController() {
        this.persistenceAPI = new PersistenceAPIImpl();
        this.businessLogicAPI = new BusinessLogicAPIImpl(this.persistenceAPI);

        this.customerManager = this.businessLogicAPI.getCustomerManager();
        this.customerManager.setCustomerStorageService(new CustomerStorageServiceImpl(this.customerManager));

    }

    @FXML
    void handleRegister(ActionEvent event) throws IOException {
        //Get values from textBoxes
        String firstName = firstNameTextBox.getText();
        String lastName = lastNameTextBox.getText();
        String email = emailTextBox.getText();
        String password = passwordTextBox.getText();
        String address = addressTextBox.getText();
        int level = 1; //TODO Customer gets stuck level needs changing in implementation(or not ;) )  - JL

        //register new Customer
        Customer customer = this.customerManager.createCustomer(firstName, lastName, email, password, address, level);
        this.customerManager.add(customer);
        //send customer to Login view
        App.setRoot("login");
    }

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        String userInpt = this.emailTextBox.getText();
        String passInpt = this.passwordTextBox.getText();
        //Take current user
        this.customerManager.getUser();
        //
        this.customerManager.

        if (login.getLoginLevel(userInpt, passInpt) == 2) {
            App.setRoot("salesOfficer");
        } else if (login.getLoginLevel(userInpt, passInpt) == 1) {
            //TODO create customer main menu - jl
            App.setRoot("editTicket");
        } else {
            //TODO Implement wrong username error thrown in fxml - jl
            App.setRoot("main");
        }
    }

    /**
     * button that sends the user to Login view
     */
    @FXML
    void loginBtnHandler(ActionEvent event) throws IOException {
        App.setRoot("login");
    }


}
