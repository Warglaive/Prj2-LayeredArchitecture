package com.flighttickets.GUI;

import com.flighttickets.App;
import com.flighttickets.BusinessLogic.BusinessLogicAPI;
import com.flighttickets.BusinessLogic.BusinessLogicAPIImpl;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceAPIImpl;
import com.flighttickets.Persistance.SystemUserStorageService;
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

public class SystemUserController implements Initializable {

    /**
     * labels and fields
     */
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

    /**
     * Buttons
     */
    @FXML
    private Button registerButton;

    @FXML
    private Button backBtn;

    @FXML
    private Button submitButton;

    @FXML
    private Button loginBtn;

    @FXML
    private ChoiceBox<String> rolePickCheckBox;
    private BusinessLogicAPI businessLogicAPI;

    private SystemUserManager systemUserManager;
    private PersistenceAPI persistenceAPI;

    /**
     * use BusinessLogicAPIImpl to create CustomerManager
     */


    public SystemUserController() {
        this.rolePickCheckBox = new ChoiceBox<>();
        this.persistenceAPI = new PersistenceAPIImpl();
        this.businessLogicAPI = new BusinessLogicAPIImpl(this.persistenceAPI);

        this.systemUserManager = this.businessLogicAPI.getSystemUserManager();
        this.systemUserManager.setSystemUserStorageService(new SystemUserStorageService(this.daoFactory));
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
        accountTypes.addAll("Customer", "SalesOfficer", "SalesEmployee", "Planner");
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
        //TODO: Catch exception and display message on the view
        SystemUser customer = this.systemUserManager.createSystemUser(0, firstName, lastName, email, password, address, role);
        this.systemUserManager.add(customer);
        //send customer to Login view
        App.setRoot("login");
    }

    @FXML
    void handleLogin(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        String loginEmail = emailTextBox.getText();
        String loginPassword = passwordTextBox.getText();
        //Take current user and pass it to the view
        SystemUser loggedInSystemUser = this.systemUserManager.login(loginEmail, loginPassword);
        System.out.println("The customer received after logging in = " + loggedInSystemUser.getEmail() + " Role =" + loggedInSystemUser.getRole());

        if (loggedInSystemUser.getRole().equals("SalesOfficer")) {
            App.setRoot("salesOfficer");
        } else if (loggedInSystemUser.getRole().equals("Planner")) {
            //TODO create customer main menu - jl
            App.setRoot("currentRoutes");
        } else if (loggedInSystemUser.getRole().equals("Customer")) {
            App.setRoot("loggedInCustomer");
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

    @FXML
    public void setRootRegister(ActionEvent actionEvent) throws IOException {
        App.setRoot("register");
    }
}
