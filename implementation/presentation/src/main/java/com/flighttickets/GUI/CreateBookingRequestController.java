package com.flighttickets.GUI;

import com.flighttickets.BusinessLogic.Exceptions.DateOutOfBoundException;
import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class CreateBookingRequestController implements Initializable {
    private final Supplier<SceneManager> sceneManagerSupplier;

    @FXML
    public Button backBtn;

    @FXML
    public DatePicker departureDate;

    @FXML
    public DatePicker returnDate;

    @FXML
    public TextField departureDestination;

    @FXML
    public TextField destination;

    @FXML
    public TextField passengersAmount;

    @FXML
    public Button submitRequestBtn;

    @FXML
    public Text welcomeText;

    @FXML
    private SystemUser customer;


    private BookingRequestManager bookingRequestManager;
    private SystemUserManager systemUserManager;

    public CreateBookingRequestController(Supplier<SceneManager> sceneManagerSupplier, SystemUser customer, BookingRequestManager bookingRequestManager, SystemUserManager systemUserManager) {
        this.customer = customer;
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.bookingRequestManager = bookingRequestManager;
        this.systemUserManager = systemUserManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.welcomeText.setText("Welcome " + this.customer.getFirstName() + " with Email " + this.customer.getEmail());
    }

    /**
     * take arguments from the fields
     * create new BookingRequest object with assigned customer id
     * save it to db
     *
     */
    @FXML
    void submitRequest() throws SQLException, ClassNotFoundException, DateOutOfBoundException {
        int initialSalesOfficerId = this.systemUserManager.generateSalesOfficerId();
        int initialId = 0;
        String initialStatus = "Pending";
        //take values from fields
        String departureDestination = this.departureDestination.getText();
        String destination = this.destination.getText();
        LocalDate departureDate = this.departureDate.getValue();
        LocalDate returnDate = this.returnDate.getValue();

        int passengersAmount = Integer.parseInt(this.passengersAmount.getText());
        //create BookingRequest object


        BookingRequest bookingRequest = this.bookingRequestManager.createBookingRequest(initialId, this.customer.getId(), initialSalesOfficerId, departureDestination, destination, departureDate, returnDate, passengersAmount, initialStatus);
        this.bookingRequestManager.add(bookingRequest);
        //this.sceneManagerSupplier.get().changeScene("AllBookingRequestsView");
    }
    public void backToView() {
        this.sceneManagerSupplier.get().changeScene("CustomerMainView");
    }
}
