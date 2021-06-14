package com.flighttickets.GUI;

import com.flighttickets.Entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import nl.fontys.sebivenlo.dao.ID;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
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

    @FXML
    private Label alert_label;

    @FXML
    private TableView<Ticket> departure_ticket_view;

    @FXML
    private TableColumn<Ticket, String> dep_ticket_id;

    @FXML
    private TableColumn<Ticket, String> dep_ticket_price;

    @FXML
    private TableColumn<Ticket, String> dep_seat_no;

    @FXML
    private TableView<Ticket> return_ticket_view;

    @FXML
    private TableColumn<Ticket, String> re_ticket_id;

    @FXML
    private TableColumn<Ticket, String> re_ticket_price;

    @FXML
    private TableColumn<Ticket, String> re_seat_no;




    private final Supplier<SceneManager> sceneManagerSupplier;
    private final BookingRequest currentRequest;
    private final BookingManager bookingManager;
    private final TicketManager ticketManager;
    private final BookingRequestManager bookingRequestManager;

    public BookingRequestHandleController(Supplier<SceneManager> sceneManagerSupplier, BookingRequest selectedRequest, BookingManager bookingManager, TicketManager ticketManager, BookingRequestManager bookingRequestManager){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.currentRequest = selectedRequest;
        this.bookingManager = bookingManager;
        this.ticketManager = ticketManager;
        this.bookingRequestManager = bookingRequestManager;
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

        //Todo Use Location to find tickets - JL
        List<Ticket> depAllOpenTickets = this.ticketManager.getOpenTickets(currentRequest.getDepartureDestination());
        ObservableList<Ticket> departureObservableList = FXCollections.observableList(depAllOpenTickets);

        departure_ticket_view.setItems(departureObservableList);
        dep_ticket_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        dep_ticket_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        dep_seat_no.setCellValueFactory(new PropertyValueFactory<>("status"));

        //Todo Use Location to find tickets - JL
        List<Ticket> reAllOpenTickets = this.ticketManager.getOpenTickets(currentRequest.getArrivalDestination());
        ObservableList<Ticket> returnObservableList = FXCollections.observableList(reAllOpenTickets);

        return_ticket_view.setItems(returnObservableList);
        re_ticket_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        re_ticket_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        re_seat_no.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @FXML
    public void requestHandler(ActionEvent event) throws IOException{
        //Gets the selected tickets from the tableview - JL
        Ticket departureflight = departure_ticket_view.getSelectionModel().getSelectedItem();
        Ticket returnflight = return_ticket_view.getSelectionModel().getSelectedItem();
        if(departureflight == null || returnflight == null){
            alert_label.setText("Please select a ticket first!");
        } else {
            //Creating a new booking returns the id of that new booking. This is inserted to the tickets. - JL
            Booking newBooking = new Booking(0, currentRequest.getCustomerId(),3,LocalDate.now());
            int resultBookingId = this.bookingManager.add(newBooking);
            //Testing result
            System.out.println("Booking made with id= " + resultBookingId);
            //Add booking to ticket.
            this.ticketManager.sell(resultBookingId, departureflight);
            this.ticketManager.sell(resultBookingId, returnflight);
            this.bookingRequestManager.acceptRequest(currentRequest);

            //Testing if all worked - JL
            System.out.println(departureflight.toString());
            System.out.println(returnflight.toString());
            //Return to main after handling request - JL
            this.sceneManagerSupplier.get().changeScene("BookingRequestOverview");
            //TODO add available tickets on date - JL
        }
    }

    //TODO add decline here instead of Overview - JL
    @FXML
    public void declineRequestHandler(ActionEvent event) throws IOException {
        BookingRequest declined = currentRequest;
        this.bookingRequestManager.declineRequest(declined);
        //TODO Implement popup window and redirect page to show deletion has been done - JL
        this.sceneManagerSupplier.get().changeScene("BookingRequestOverview");
    }


    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("BookingRequestOverview");
    }
}
