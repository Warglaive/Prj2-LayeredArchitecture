package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Supplier;

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

    /**
     * use BusinessLogicAPIImpl to create CustomerManager
     */

    private final Supplier<SceneManager> sceneManagerSupplier;
    private BookingRequestManager bookingRequestManager;
    private SystemUserManager systemUserManager;
    private SystemUser loggedInSystemUser;

    public SystemUserController(Supplier<SceneManager> sceneManagerSupplier, SystemUserManager systemUserManager, BookingRequestManager bookingRequestManager) {
        this.rolePickCheckBox = new ChoiceBox<>();

        this.sceneManagerSupplier = sceneManagerSupplier;
        this.systemUserManager = systemUserManager;
        this.bookingRequestManager = bookingRequestManager;
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
    void handleRegister() throws SQLException, ClassNotFoundException {
        //Get values from textBoxes
        int initialId = 0;
        String firstName = firstNameTextBox.getText();
        String lastName = lastNameTextBox.getText();
        String email = emailTextBox.getText();
        String password = passwordTextBox.getText();
        String address = addressTextBox.getText();
        String role = rolePickCheckBox.getValue();

        //register new Customer
        //TODO: Catch exception and display message on the view
        SystemUser customer = this.systemUserManager.createSystemUser(initialId, firstName, lastName, email, password, address, role);
        this.systemUserManager.add(customer);
        //send customer to Login view
        this.sceneManagerSupplier.get().changeScene("login");
    }

    @FXML
    void handleLogin() throws ClassNotFoundException, IOException {
        String loginEmail = emailTextBox.getText();
        String loginPassword = passwordTextBox.getText();
        //Take current user and pass it to the view

        this.loggedInSystemUser = this.systemUserManager.login(loginEmail, loginPassword);
        System.out.println("The customer received after logging in = " + loggedInSystemUser.getEmail() + " Role = " + loggedInSystemUser.getRole());

        if (loggedInSystemUser.getRole().equals("SalesOfficer")) {
            this.sceneManagerSupplier.get().changeScene("salesOfficer");

        } else if (loggedInSystemUser.getRole().equals("Planner")) {
            //TODO create customer main menu - jl
            this.sceneManagerSupplier.get().changeScene("currentRoutes");

        } else if (loggedInSystemUser.getRole().equals("SalesEmployee")) {
            this.sceneManagerSupplier.get().changeScene("BookingRequestOverview");

        } else if (loggedInSystemUser.getRole().equals("Customer")) {
            this.sceneManagerSupplier.get().changeScene("CustomerMainView");

        } else {
            //TODO Implement wrong username error thrown in fxml - jl
            this.sceneManagerSupplier.get().changeScene("Main");

        }
    }

    /**
     * button that sends the user to Login view from Register view
     */
    @FXML
    void viewLogin() {
        this.sceneManagerSupplier.get().changeScene("Login");
    }

    /**
     * returns to "main" view
     */
    public void viewMain() {
        this.sceneManagerSupplier.get().changeScene("Main");

    }

    /**
     * return to register
     *
     * @throws IOException
     */
    @FXML
    public void viewRegister() {
        this.sceneManagerSupplier.get().changeScene("Register");

    }

    /**
     * used to pass customer object to CustomerMainView
     * @return
     */
    public SystemUser getLoggedInCustomer() {
        return this.loggedInSystemUser;
    }
}
