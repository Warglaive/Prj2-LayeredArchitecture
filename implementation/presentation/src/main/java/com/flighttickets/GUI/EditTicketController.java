package com.flighttickets.GUI;

import com.flighttickets.Entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class EditTicketController implements Initializable {


    @FXML
    private TextField searchTbx;

    @FXML
    private Label searchLbl;

    @FXML
    private Button deleteTicketBtn;

    @FXML
    private Button searchBtn;

    @FXML
    private Button editBtn;

    @FXML
    private Button addDiscountBtn;

    @FXML
    private Button editDiscountBtn;
    @FXML
    private TableView<TicketGUI> ticketView;

    @FXML
    private TableColumn<?, Integer> ticketId;

    @FXML
    private TableColumn<?, ?> ticketStatus;

    @FXML
    private TableColumn<?, ?> ticketPassenger;

    @FXML
    private TableColumn<?, ?> ticketBooking;

    @FXML
    private TableColumn<?, ?> ticketRouteStart;

    @FXML
    private TableColumn<?, ?> ticketRouteEnd;

    @FXML
    private TableColumn<?, ?> ticketPrice;



    private final Supplier<SceneManager> sceneManagerSupplier;
    private TicketManager ticketManager;
    private SystemUserManager systemUserManager;
    private SystemUser salesEmployee;
    private final RouteManager routeManager;
    private final AirportManager airportManager;
    private final FlightManager flightManager;
    private final BookingManager bookingManager;

    public Ticket getSelectedTicket() {
        return selectedTicket;
    }

    private Ticket selectedTicket;

    public EditTicketController(Supplier<SceneManager> sceneManagerSupplier,SystemUser salesEmployee, SystemUserManager systemUserManager, TicketManager ticketManager, FlightManager flightManager , RouteManager routeManager, AirportManager airportManager, BookingManager bookingManager){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.ticketManager = ticketManager;
        this.systemUserManager = systemUserManager;
        this.salesEmployee = salesEmployee;
        this.flightManager = flightManager;
        this.routeManager = routeManager;
        this.airportManager = airportManager;
        this.bookingManager = bookingManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Ticket> ticketList = ticketManager.getAll();
        List<TicketGUI> observables = new ArrayList<TicketGUI>();
        for(Ticket ticket : ticketList){
            int id = ticket.getId();
            String status = ticket.getStatus();
            int ticketPassenger = ticket.getPassengerid();
            LocalDate booking = bookingManager.getBooking(ticket.getBookingid()).getBookingDate();
            Flight flight = flightManager.getFlightById(ticket.getFlightid());
            Route route = routeManager.getByRouteId(flight.getRouteid());
            String startAirport = airportManager.getAirport(route.getStart_airport()).getName();
            String endAirport = airportManager.getAirport(route.getEnd_airport()).getName();
            double ticketPrice = ticket.getPrice();


            observables.add(new TicketGUI(id, status, ticketPassenger, booking, startAirport, endAirport, ticketPrice));

            System.out.println("observable added");
        }

        if(observables.size() != 0) {
            ObservableList<TicketGUI> tickets = FXCollections.observableList(observables);
            ticketView.setItems(tickets);
            this.ticketId.setCellValueFactory(new PropertyValueFactory<>("id"));
            this.ticketStatus.setCellValueFactory(new PropertyValueFactory<>("ticketStatus"));
            this.ticketPassenger.setCellValueFactory(new PropertyValueFactory<>("ticketPassenger"));
            this.ticketBooking.setCellValueFactory(new PropertyValueFactory<>("ticketBooking"));
            this.ticketRouteStart.setCellValueFactory(new PropertyValueFactory<>("ticketRouteStart"));
            this.ticketRouteEnd.setCellValueFactory(new PropertyValueFactory<>("ticketRouteEnd"));
            this.ticketPrice.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));
        }
    }

    @FXML
    void DeleteTicketDiag(ActionEvent event) {

    }

    @FXML
    void addDiscountDiag(ActionEvent event) {

    }

    @FXML
    void editDiscountDiag(ActionEvent event) {

    }

    @FXML
    void editTicketPopup(ActionEvent event) {
        if(ticketView.getSelectionModel().getSelectedItems().size() == 1){
            this.selectedTicket = ticketManager.getById(ticketView.getSelectionModel().getSelectedItem().getId());

            sceneManagerSupplier.get().changeScene("editTicketData"); //when you wake up, change list to a table, it's easier that way
        }
    }

    @FXML
    void search(ActionEvent event) {

    }

}
