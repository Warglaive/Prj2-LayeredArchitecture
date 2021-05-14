package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import com.flighttickets.GUI.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class CreateBookingRequestController implements Initializable {
    private final Supplier<SceneManager> sceneManagerSupplier;
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
    public Button submitRequest;

    @FXML
    public Text welcomeText;

    @FXML
    private Button refreshBtn;

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
        this.customer = customer;
        this.welcomeText.setText(this.customer.getFirstName());

    }
}
