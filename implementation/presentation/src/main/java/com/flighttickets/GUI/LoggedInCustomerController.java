package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
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

public class LoggedInCustomerController {
    /**
     * FXML elements for create a booking request
     */

    @FXML
    private DatePicker departureDate;

    @FXML
    private DatePicker returnDate;

    @FXML
    private TextField departureDestination;

    @FXML
    private TextField destination;

    @FXML
    private TextField passengersAmount;

    @FXML
    private Text welcomeText;

    @FXML
    private Button refreshButton;

    @FXML
    private Button submitRequest;

    private final Supplier<SceneManager> sceneManagerSupplier;
    private BookingRequestManager bookingRequestManager;
    private SystemUserManager systemUserManager;

    private SystemUser customer;


    public LoggedInCustomerController(Supplier<SceneManager> sceneManagerSupplier, BookingRequestManager bookingRequestManager, SystemUserManager systemUserManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.bookingRequestManager = bookingRequestManager;
        this.systemUserManager = systemUserManager;
    }



    public void setCustomer(SystemUser customer) {
        this.customer = customer;
    }

    @FXML
    public void refreshWelcomeMsg(ActionEvent actionEvent) {
      //  this.welcomeText.setText("asdasd");
    }
    //TODO: Customer operations based on use case
}
