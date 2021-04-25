package com.flighttickets.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
    private Button submitRequest;

}
