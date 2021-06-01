package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingManager;
import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.SystemUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class FinalizeBookingRequestController implements Initializable {
    @FXML
    private Button finalizeBtn;

    @FXML
    private Button backBtn;
    private Supplier<SceneManager> sceneManagerSupplier;
    SystemUser loggedInCustomer;
    BookingRequest toBeFinalized;
    BookingManager bookingManager;

    public FinalizeBookingRequestController(Supplier<SceneManager> getSceneManager, SystemUser loggedInCustomer, BookingRequest toBeFinalized, BookingManager bookingManager) {
        this.loggedInCustomer = loggedInCustomer;
        this.sceneManagerSupplier = getSceneManager;
        this.toBeFinalized = toBeFinalized;
        this.bookingManager = bookingManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO:

    }

    @FXML
    public void finalizeBookingRequest() {
        //TODO:
    }


    public void backToView() {
        this.sceneManagerSupplier.get().changeScene("CustomerMainView");
    }
}
