package com.flighttickets.GUI;

import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.Ticket;
import com.flighttickets.Entities.TicketManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class EditTicketDataController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final TicketManager ticketManager;
    private final SystemUser systemUserManager;

    @FXML
    private Button backBtn;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField TicketIdTbx;

    @FXML
    private TextField PriceTbx;

    @FXML
    private TextField PassengerIdTbx;

    @FXML
    private TextField BookingIdTbx;

    @FXML
    private TextField FlightIdTbx;

    @FXML
    private TextField StatusTbx;

    private Ticket selected;
    public EditTicketDataController(Supplier<SceneManager> sceneManagerSupplier, SystemUser loggedInCustomer, TicketManager ticketManager, Ticket selected) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.ticketManager = ticketManager;
        this.systemUserManager = loggedInCustomer;
        this.selected = selected;
    }

    @FXML
    void backHandler(ActionEvent event) {
        this.sceneManagerSupplier.get().changeScene("editTicket");
    }

    @FXML
    void submitHandler(ActionEvent event) throws SQLException, ClassNotFoundException {
        Ticket ticket;
        try {
            ticket = ticketManager.createTicket(Integer.parseInt(TicketIdTbx.getText()), Integer.parseInt(PriceTbx.getText()), Integer.parseInt(PassengerIdTbx.getText()), Integer.parseInt(BookingIdTbx.getText()), Integer.parseInt(FlightIdTbx.getText()), StatusTbx.getText());
        }
        catch (NumberFormatException e){
            System.out.println("Number format exception"); //TODO: error message.
            return;
        }
        ticketManager.edit(Integer.parseInt(TicketIdTbx.getText()), ticket);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Ticket currentTicket = this.selected;

        TicketIdTbx.setText(Integer.toString(currentTicket.getId()));
        PriceTbx.setText(Integer.toString(currentTicket.getPrice()));
        PassengerIdTbx.setText(Integer.toString(currentTicket.getPassengerid()));
        BookingIdTbx.setText(Integer.toString(currentTicket.getBookingid()));
        FlightIdTbx.setText(Integer.toString(currentTicket.getFlightid()));
        StatusTbx.setText(currentTicket.getStatus());

    }
}
