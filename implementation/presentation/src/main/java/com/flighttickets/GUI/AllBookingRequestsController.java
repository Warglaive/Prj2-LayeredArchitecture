package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;


public class AllBookingRequestsController implements Initializable {

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
    void cancelBookingRequest(ActionEvent event) {

    }

    @FXML
    void finalizeBookingRequest(ActionEvent event) {

    }


    private Supplier<SceneManager> sceneManagerSupplier;
    private SystemUser loggedInCustomer;
    private BookingRequestManager bookingRequestManager;
    private SystemUserManager systemUserManager;


    private BookingRequest BookingRequestLeft;
    private BookingRequest BookingRequestMid;
    private BookingRequest BookingRequestRight;


    public AllBookingRequestsController(Supplier<SceneManager> sceneManagerSupplier, SystemUser loggedInCustomer, BookingRequestManager bookingRequestManager, SystemUserManager systemUserManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.loggedInCustomer = loggedInCustomer;
        this.bookingRequestManager = bookingRequestManager;
        this.systemUserManager = systemUserManager;


        //TODO: Find way to take data from DB without causing an exception.
        this.BookingRequestLeft = this.bookingRequestManager.getAllByCustomerId(this.loggedInCustomer.getId()).get(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO: 1. Get all 3 booking requests and assign to fields
        this.customerLeft.setText(this.loggedInCustomer.getFirstName());
    }

}
