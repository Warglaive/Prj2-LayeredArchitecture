package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.GUIApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class CustomerMainViewController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;
    private SystemUser loggedInCustomer;
    private final BookingRequestManager bookingRequestManager;
    public Button logoutBtn;

    @FXML
    private TitledPane titledPane;

    @FXML
    private Button newBookingRequestBtn;

    @FXML
    private Button viewAllBookingRequestsBtn;

    @FXML
    private Text hiNameText;

    public CustomerMainViewController(Supplier<SceneManager> sceneManagerSupplier, SystemUser loggedInCustomer, BookingRequestManager bookingRequestManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.loggedInCustomer = loggedInCustomer;
        this.bookingRequestManager = bookingRequestManager;
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.hiNameText.setText(this.loggedInCustomer.getFirstName());
    }

    @FXML
    void viewAllBookingRequests() {
        //TODO: Implement
        this.sceneManagerSupplier.get().changeScene("AllBookingRequests");
    }

    @FXML
    void viewBookingRequestCreation() {
        this.sceneManagerSupplier.get().changeScene("CreateBookingRequest");
    }

    //TODO: Move to SystemUserController
    @FXML
    public void logout() {
        this.sceneManagerSupplier.get().changeScene("Main");
    }
}
