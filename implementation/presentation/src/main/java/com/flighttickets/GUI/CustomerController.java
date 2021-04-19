package com.flighttickets.GUI;

import com.flighttickets.App;
import com.flighttickets.BusinessLogic.BusinessLogicAPI;
import com.flighttickets.BusinessLogic.BusinessLogicAPIImpl;
import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageService;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceAPIImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.flighttickets.App.pdaof;

public class CustomerController implements Initializable {
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
    private PasswordField passwordTextBox;

    @FXML
    private Label addressLabel;

    @FXML
    private TextField addressTextBox;

    @FXML
    private Label accountTypeLbl;

    @FXML
    private Button registerButton;

    @FXML
    private Button backBtn;

    @FXML
    private Button submitButton;

    @FXML
    private ChoiceBox<String> rolePickCheckBox;
    BusinessLogicAPI businessLogicAPI;

    CustomerManager customerManager;
    PersistenceAPI persistenceAPI;

    /**
     * use BusinessLogicAPIImpl to create CustomerManager
     */


    public CustomerController() {
        this.rolePickCheckBox = new ChoiceBox<>();
        this.persistenceAPI = new PersistenceAPIImpl();
        this.businessLogicAPI = new BusinessLogicAPIImpl(this.persistenceAPI);

        this.customerManager = this.businessLogicAPI.getCustomerManager();
        this.customerManager.setCustomerStorageService(new CustomerStorageService());
    }


    /**
     * ComboBox filler
     *
     * @param url
     * @param resources
     */
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        ObservableList<String> accountTypes = FXCollections.observableArrayList();
        accountTypes.addAll("Customer", "SalesOfficer", "SalesEmployee");
        rolePickCheckBox.setItems(accountTypes);
    }

    @FXML
    void handleRegister(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        //Get values from textBoxes
        String firstName = firstNameTextBox.getText();
        String lastName = lastNameTextBox.getText();
        String email = emailTextBox.getText();
        String password = passwordTextBox.getText();
        String address = addressTextBox.getText();
        String role = rolePickCheckBox.getValue();

        //register new Customer
        Customer customer = this.customerManager.createCustomer(0,firstName, lastName, email, password, address, role);
        this.customerManager.add(customer);
        //send customer to Login view
        App.setRoot("login");
    }

    @FXML
    void handleLogin(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        String loginEmail = emailTextBox.getText();
        String loginPassword = passwordTextBox.getText();
        //Take current user and pass it to the view
        Customer loggedInCustomer = this.customerManager.login(loginEmail, loginPassword);
        System.out.println("The customer received after logging in = "+ loggedInCustomer.getEmail() +" Role ="+ loggedInCustomer.getRole());

        if (loggedInCustomer.getRole().equals("SalesOfficer")) {
            App.setRoot("salesOfficer");
        } else if (loggedInCustomer.getRole().equals("SalesEmployee")) {
            //TODO create customer main menu - jl
            App.setRoot("main");
        } else if (loggedInCustomer.getRole().equals("Customer")) {
            //TODO create customer main menu - jl
            App.setRoot("main");
        } else {
            //TODO Implement wrong username error thrown in fxml - jl
            App.setRoot("main");
        }
    }

    /**
     * button that sends the user to Login view from Register view
     */
    @FXML
    void loginBtnHandler(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

    /**
     * returns to "main" view
     *
     * @param event
     * @throws IOException
     */
    public void backBtnHandler(ActionEvent event) throws IOException {
        App.setRoot("main");
    }


}
