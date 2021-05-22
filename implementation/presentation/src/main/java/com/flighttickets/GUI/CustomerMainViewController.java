package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class CustomerMainViewController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final SystemUser loggedInCustomer;
    private final BookingRequestManager bookingRequestManager;

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
     *
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


}
