package com.flighttickets.GUI;

import com.flighttickets.Entities.Booking;
import com.flighttickets.Entities.BookingManager;
import com.flighttickets.Entities.BookingRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class BookingRequestHandleController implements Initializable {

    @FXML
    private Button back_btn;

    @FXML
    private Button handleRequest_btn;

    @FXML
    private Label bookingRequest_id_label;

    @FXML
    private Label customer_id_label;

    @FXML
    private Label requestDepartureLocation_label;

    @FXML
    private Label requestDestinationLocation_label;

    @FXML
    private Label requestDepartureDate_label;

    @FXML
    private Label requestReturnDate_label;

    @FXML
    private Label passengerCount_label;

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final BookingRequest currentRequest;
    private final BookingManager bookingManager;

    public BookingRequestHandleController(Supplier<SceneManager> sceneManagerSupplier, BookingRequest selectedRequest, BookingManager newBooking){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.currentRequest = selectedRequest;
        this.bookingManager = newBooking;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookingRequest_id_label.setText(String.valueOf(currentRequest.getId()));
        customer_id_label.setText(String.valueOf(currentRequest.getCustomerId()));
        requestDepartureLocation_label.setText(currentRequest.getDepartureDestination());
        requestDestinationLocation_label.setText(currentRequest.getArrivalDestination());
        requestDepartureDate_label.setText(String.valueOf(currentRequest.getDepartureDate()));
        requestReturnDate_label.setText(String.valueOf(currentRequest.getReturnDate()));
        passengerCount_label.setText(String.valueOf(currentRequest.getPassengersAmount()));
    }

    @FXML
    public void requestHandler(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        Booking test = new Booking(0, 2,3,LocalDate.now());
        this.bookingManager.add(test);
        System.out.println("added new booking");
        //this.sceneManagerSupplier.get().changeScene("BookingRequestOverview");
        //TODO add actual available flights on date and tickets to db
    }


    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("BookingRequestOverview");
    }
}
