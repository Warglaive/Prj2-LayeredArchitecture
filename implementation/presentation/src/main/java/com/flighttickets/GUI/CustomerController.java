package com.flighttickets.GUI;

import com.flighttickets.App;
import com.flighttickets.BusinessLogic.BusinessLogicAPI;
import com.flighttickets.BusinessLogic.BusinessLogicAPIImpl;
import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageServiceImpl;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceAPIImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    private ComboBox<String> accountTypeCbx;

    @FXML
    private Label accountTypeLbl;

    @FXML
    private Button registerButton;

    @FXML
    private Button backBtn;

    @FXML
    private Button submitButton;
    @FXML
    private ChoiceBox<Enum> enumChoiceBox;
    BusinessLogicAPI businessLogicAPI;

    CustomerManager customerManager;
    PersistenceAPI persistenceAPI;

    /**
     * use BusinessLogicAPIImpl to create CustomerManager
     */
    public CustomerController() {
        this.persistenceAPI = new PersistenceAPIImpl();
        this.businessLogicAPI = new BusinessLogicAPIImpl(this.persistenceAPI);

        this.customerManager = this.businessLogicAPI.getCustomerManager();
        this.customerManager.setCustomerStorageService(new CustomerStorageServiceImpl(this.customerManager));

    }

    /**
     * ComboBox filler
     *
     * @param url
     * @param resources
     */
    @Override
    public void initialize(URL url, ResourceBundle resources) {
//        ObservableList<String> accountTypes = FXCollections.observableArrayList();
//        accountTypes.addAll("Customer", "SalesOfficer", "Admin");
//        accountTypeCbx.setItems(accountTypes);
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
    void handleLogin(ActionEvent event) throws IOException, ClassNotFoundException {
        String loginEmail = this.emailTextBox.getText();
        String loginPassword = this.passwordTextBox.getText();
        //Take current user and pass it to the view
        Customer loggedInCustomer = this.customerManager.login(loginEmail, loginPassword);
        //

    /*    if (loggedInCustomer.getLevel() == 2) {
            App.setRoot("salesOfficer");
        } else if (login.getLoginLevel(loginEmail, loginPassword) == 1) {
            //TODO create customer main menu - jl
            App.setRoot("editTicket");
        } else {
            //TODO Implement wrong username error thrown in fxml - jl
            App.setRoot("main");
        }*/
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
