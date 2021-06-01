package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingManager;
import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.SystemUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class FinalizeBookingRequestController implements Initializable {
    /**
     * Tuesday and Thursday are to be expensive days
     */
    double expensiveDayMultiplier = 1.56;

    /**
     * Monday and Wednesday are to be cheap days
     */
    double cheapDayMultiplier = 0.5;

    /**
     * Friday, Saturday and Sunday are to be normal days
     */
    int normalDayMultiplier = 1;

    double riskyNationMultiplier = 2.12;


    /**
     * hardcoded ticket price for the sake of my useCase
     */
    private double ticketPrice = 100;


    List<String> riskyDestinationsList;

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
        this.bookingManager = bookingManager;
        this.riskyDestinationsList = new ArrayList<>() {{
            add("Libya");
            add("Syria");
            add("Iraq");
            add("Yemen");
            add("Somalia");
            add("South Sudan");
            add("Central African Republic");
            add("Part of the Congo");
            add("Mali");
            add("Afghanistan");
        }};
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO: Calculate ticket price and display on view
        calculateTicketPrice();
        this.ticketPriceText.setText(String.valueOf(this.ticketPrice));
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

    /**
     * @return calculated price based on several factors (age, day of week, destination, discount coupon)
     */
    private void calculateTicketPrice() {
        //Multiply ticket price regarding to the day
        if (this.toBeFinalized.getDepartureDate().getDayOfWeek().equals(DayOfWeek.TUESDAY)
                || this.toBeFinalized.getDepartureDate().getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
            this.ticketPrice *= this.expensiveDayMultiplier;
        } else if (toBeFinalized.getDepartureDate().getDayOfWeek().equals(DayOfWeek.MONDAY)
                || toBeFinalized.getDepartureDate().getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {
            this.ticketPrice *= cheapDayMultiplier;
        } else {
            this.ticketPrice *= normalDayMultiplier;
        }
        //Multiply by risky nation
        //TODO: Make case insensitive
        if (this.riskyDestinationsList.contains(this.toBeFinalized.getArrivalDestination())) {
            this.ticketPrice *= this.riskyNationMultiplier;
        }
    }
}
