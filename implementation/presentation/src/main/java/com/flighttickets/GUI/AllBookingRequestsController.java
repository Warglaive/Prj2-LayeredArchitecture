package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;


public class AllBookingRequestsController implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    public Text custEmail;

    @FXML
    public Text lName;

    @FXML
    public Text fName;

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


    private Supplier<SceneManager> sceneManagerSupplier;
    private SystemUser loggedInCustomer;
    private BookingRequestManager bookingRequestManager;
    private SystemUserManager systemUserManager;


    private BookingRequest bookingRequestLeft;
    private BookingRequest bookingRequestMid;
    private BookingRequest bookingRequestRight;


    public AllBookingRequestsController(Supplier<SceneManager> sceneManagerSupplier, SystemUser loggedInCustomer, BookingRequestManager bookingRequestManager, SystemUserManager systemUserManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.loggedInCustomer = loggedInCustomer;
        this.bookingRequestManager = bookingRequestManager;
        this.systemUserManager = systemUserManager;


        //TODO: Find way to take data from DB without causing an exception.
        this.bookingRequestLeft = this.bookingRequestManager.getAllByCustomerId(this.loggedInCustomer.getId()).get(0);
        this.bookingRequestMid = this.bookingRequestManager.getAllByCustomerId(this.loggedInCustomer.getId()).get(1);
        this.bookingRequestRight = this.bookingRequestManager.getAllByCustomerId(this.loggedInCustomer.getId()).get(2);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.anchor.resize(1200, 1200);
//        this.anchor.setMinSize(1200, 1200);

        //TODO: 1. Get all 3 booking requests and assign to fields
        fillCustomer();
        fillLeftBookingRequest();
        fillMidBookingRequest();
        fillRightBookingRequest();

    }

    private void fillCustomer() {
        this.fName.setText(this.loggedInCustomer.getFirstName());
        this.lName.setText(this.loggedInCustomer.getLastName());
        this.custEmail.setText(this.loggedInCustomer.getEmail());

    }

    private void fillRightBookingRequest() {
        this.deptDateRight.setText("Departure date: " + this.bookingRequestRight.getDepartureDate());
        this.returnDateRight.setText("Return date: " + this.bookingRequestRight.getReturnDate());
        this.departureDestinationRight.setText("Departure from: " + this.bookingRequestRight.getDepartureDestination());
        this.destinationRight.setText("Destination: " + this.bookingRequestRight.getArrivalDestination());
        this.salesOfficerRight.setText("Sales Officer: " + this.bookingRequestRight.getSalesOfficerId());
        this.passengersAmountRight.setText("Passengers amount: " + this.bookingRequestRight.getPassengersAmount());
        this.statusRight.setText("Status: " + this.bookingRequestRight.getStatus());

        //TODO: USe that for changing color
        if (this.bookingRequestRight.getStatus().equalsIgnoreCase("approved")) {
            this.statusRight.setFill(Paint.valueOf("green"));
        } else if (this.bookingRequestRight.getStatus().equalsIgnoreCase("declined")) {
            this.statusRight.setFill(Paint.valueOf("red"));
        } else {
            this.statusRight.setFill(Paint.valueOf("orange"));
        }
    }

    private void fillMidBookingRequest() {
        this.deptDateMid.setText("Departure date: " + this.bookingRequestMid.getDepartureDate());
        this.returnDateMid.setText("Return date: " + this.bookingRequestMid.getReturnDate());
        this.departureDestinationMid.setText("Departure from: " + this.bookingRequestMid.getDepartureDestination());
        this.destinationMid.setText("Destination: " + this.bookingRequestMid.getArrivalDestination());
        this.salesOfficerMid.setText("Sales Officer: " + this.bookingRequestMid.getSalesOfficerId());
        this.passengersAmountMid.setText("Passengers amount: " + this.bookingRequestMid.getPassengersAmount());
        this.statusMid.setText("Status: " + this.bookingRequestMid.getStatus());

        if (this.bookingRequestMid.getStatus().equalsIgnoreCase("approved")) {
            this.statusMid.setFill(Paint.valueOf("green"));
        } else if (this.bookingRequestMid.getStatus().equalsIgnoreCase("declined")) {
            this.statusMid.setFill(Paint.valueOf("red"));
        } else {
            this.statusMid.setFill(Paint.valueOf("yellow"));
        }
    }

    private void fillLeftBookingRequest() {
        this.deptDateLeft.setText("Departure date: " + this.bookingRequestLeft.getDepartureDate());
        this.returnDateLeft.setText("Return date: " + this.bookingRequestLeft.getReturnDate());
        this.departureDestinationLeft.setText("Departure from: " + this.bookingRequestLeft.getDepartureDestination());
        this.destinationLeft.setText("Destination: " + this.bookingRequestLeft.getArrivalDestination());
        this.salesOfficerLeft.setText("Sales Officer: " + this.bookingRequestLeft.getSalesOfficerId());
        this.passengersAmountLeft.setText("Passengers amount: " + this.bookingRequestLeft.getPassengersAmount());
        this.statusLeft.setText("Status: " + this.bookingRequestLeft.getStatus());


        if (this.bookingRequestLeft.getStatus().equalsIgnoreCase("approved")) {
            this.statusMid.setFill(Paint.valueOf("green"));
        } else if (this.bookingRequestLeft.getStatus().equalsIgnoreCase("declined")) {
            this.statusLeft.setFill(Paint.valueOf("red"));
        } else {
            this.statusLeft.setFill(Paint.valueOf("yellow"));
        }
    }

}
