package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class CustomerMainViewController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final SystemUser loggedInCustomer;


    @FXML
    private TitledPane titledPane;

    @FXML
    private Button newBookingRequestBtn;


    public CustomerMainViewController(Supplier<SceneManager> sceneManagerSupplier, SystemUser loggedInCustomer, BookingRequestManager bookingRequestManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.loggedInCustomer = loggedInCustomer;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void viewBookingRequestCreation() {
        this.sceneManagerSupplier.get().changeScene("CreateBookingRequest");
    }
}
