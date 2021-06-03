package com.flighttickets.GUI;

import com.flighttickets.BusinessLogic.BookingManagerImpl;
import com.flighttickets.Entities.BookingManager;
import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.SystemUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class FinalizeBookingRequestController implements Initializable {
    @FXML
    public Text ticketPriceText;

    @FXML
    private Button finalizeBtn;

    @FXML
    private Button backBtn;

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private TextField passportNumber;


    private final Supplier<SceneManager> sceneManagerSupplier;
    SystemUser loggedInCustomer;
    BookingRequest toBeFinalized;
    BookingManager bookingManager;

    public FinalizeBookingRequestController(Supplier<SceneManager> getSceneManager, SystemUser loggedInCustomer, BookingRequest toBeFinalized, BookingManager bookingManager) {
        this.loggedInCustomer = loggedInCustomer;
        this.sceneManagerSupplier = getSceneManager;
        this.toBeFinalized = toBeFinalized;
        this.bookingManager = new BookingManagerImpl(this.toBeFinalized);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO: Calculate ticket price and display on view
        this.ticketPriceText.setText(String.valueOf(this.bookingManager.calculatePrice()));
    }

    /**
     * create a booking and save it into the DB.
     */
    @FXML
    public void finalizeBookingRequest() {
        throw new UnsupportedOperationException();
     /*   int initialId = 0;
        this.bookingManager.createBooking(initialId, this.toBeFinalized.getSalesOfficerId(), this.loggedInCustomer.getId(), this.toBeFinalized.getDepartureDate());*/
        //TODO: create ticket from price (requires flight, route and other objects to be into the DB for proper FK handling)
    }

    @FXML
    public void backToView() {
        this.sceneManagerSupplier.get().changeScene("CustomerMainView");
    }
}
