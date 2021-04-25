package com.flighttickets.GUI;

import com.flighttickets.BusinessLogic.BusinessLogicAPI;
import com.flighttickets.BusinessLogic.BusinessLogicAPIImpl;
import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUserManager;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceAPIImpl;
import com.flighttickets.Persistance.SystemUserStorageService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInCustomerController implements Initializable {
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
    private Button submitRequest;
    /**
     *
     */
    private BusinessLogicAPI businessLogicAPI;

    private BookingRequestManager bookingRequestManager;
    private PersistenceAPI persistenceAPI;

    public LoggedInCustomerController() {
        this.persistenceAPI = new PersistenceAPIImpl();
        this.businessLogicAPI = new BusinessLogicAPIImpl(this.persistenceAPI);

        this.bookingRequestManager = this.businessLogicAPI.getBookingRequestManager();
        this.bookingRequestManager.setBookingRequestStorageService(new SystemUserStorageService());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
