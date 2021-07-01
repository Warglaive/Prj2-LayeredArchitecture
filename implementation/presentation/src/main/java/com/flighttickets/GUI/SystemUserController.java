package com.flighttickets.GUI;

import com.flighttickets.BusinessLogic.Exceptions.SystemUserStorageException;
import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.security.auth.login.AccountNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLOutput;
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

    @FXML
    private Label alert_label;

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
    void handleLogin() throws ClassNotFoundException, IOException, SystemUserStorageException, AccountNotFoundException {
        String loginEmail = emailTextBox.getText();
        String loginPassword = passwordTextBox.getText();
        String errorMsg = null;
        //Take current user and pass it to the view
        try {
        this.loggedInSystemUser = this.systemUserManager.login(loginEmail, loginPassword);
        } catch (AccountNotFoundException e){
            //Account not found exception
            System.out.println(e);
            errorMsg = e.getMessage();
        } catch (SystemUserStorageException e){
            //SomeHow there is 2 accounts on the same email/password contact the administrator!
            System.out.println(e);
            errorMsg = e.getMessage();
        }

        if(loggedInSystemUser != null){
            if (loggedInSystemUser.getRole().equals("SalesOfficer")) {
                this.sceneManagerSupplier.get().changeScene("salesOfficer");
                System.out.println("The user received after logging in = " + loggedInSystemUser.getEmail() + " Role = " + loggedInSystemUser.getRole());
            } else if (loggedInSystemUser.getRole().equals("Planner")) {
                this.sceneManagerSupplier.get().changeScene("currentRoutes");
                System.out.println("The user received after logging in = " + loggedInSystemUser.getEmail() + " Role = " + loggedInSystemUser.getRole());
            } else if (loggedInSystemUser.getRole().equals("SalesEmployee")) {
                this.sceneManagerSupplier.get().changeScene("BookingRequestOverview");
                System.out.println("The user received after logging in = " + loggedInSystemUser.getEmail() + " Role = " + loggedInSystemUser.getRole());
            } else if (loggedInSystemUser.getRole().equals("Customer")) {
                this.sceneManagerSupplier.get().changeScene("CustomerMainView");
                System.out.println("The user received after logging in = " + loggedInSystemUser.getEmail() + " Role = " + loggedInSystemUser.getRole());
            }
        } else {
            //TODO Implement wrong username error thrown in fxml - jl
            alert_label.setText("There was an error: " + errorMsg);
            //this.sceneManagerSupplier.get().changeScene("Main");
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
