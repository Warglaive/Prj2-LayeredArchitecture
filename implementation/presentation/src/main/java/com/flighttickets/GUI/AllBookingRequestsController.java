package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;


public class AllBookingRequestsController implements Initializable {
    private final Supplier<SceneManager> sceneManagerSupplier;
    private final SystemUser loggedInCustomer;
    private final BookingRequestManager bookingRequestManager;
    private final SystemUserManager systemUserManager;

    public AllBookingRequestsController(Supplier<SceneManager> sceneManagerSupplier, SystemUser loggedInCustomer, BookingRequestManager bookingRequestManager, SystemUserManager systemUserManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.loggedInCustomer = loggedInCustomer;
        this.bookingRequestManager = bookingRequestManager;
        this.systemUserManager = systemUserManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private VBox vboxLeft;

    @FXML
    private Text deptDateLeft;

    @FXML
    private Text returnDateLeft;

    @FXML
    private Text departureDestinationLeft;

    @FXML
    private Text destinationLeft;

    @FXML
    private Text customerLeft;

    @FXML
    private Text salesOfficerLeft;

    @FXML
    private Text passengersAmountLeft;

    @FXML
    private Text statusLeft;

    @FXML
    private Button finalizeBtnLeft;

    @FXML
    private Button cancelBtnLeft;

    @FXML
    private VBox vboxMid;

    @FXML
    private Text deptDateMid;

    @FXML
    private Text returnDateMid;

    @FXML
    private Text departureDestinationMid;

    @FXML
    private Text destinationMid;

    @FXML
    private Text customerMid;

    @FXML
    private Text salesOfficerMid;

    @FXML
    private Text passengersAmountMid;

    @FXML
    private Text statusMid;

    @FXML
    private Button finalizeBtnMid;

    @FXML
    private Button cancelBtnMid;

    @FXML
    private VBox vboxRight;

    @FXML
    private Text deptDateRight;

    @FXML
    private Text returnDateRight;

    @FXML
    private Text departureDestinationRight;

    @FXML
    private Text destinationRight;

    @FXML
    private Text customerRight;

    @FXML
    private Text salesOfficerRight;

    @FXML
    private Text passengersAmountRight;

    @FXML
    private Text statusRight;

    @FXML
    private Button finalizeBtnRight;

    @FXML
    private Button cancelBtnRight;

    @FXML
    void cancelBookingRequest() {

    }

    @FXML
    void finalizeBookingRequest() {

    }
}
