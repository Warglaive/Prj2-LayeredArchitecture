package com.flighttickets.GUI;

import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import com.flighttickets.Entities.Ticket;
import com.flighttickets.Entities.TicketManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class EditTicketController implements Initializable {



    @FXML
    private TextField searchTbx;

    @FXML
    private Label searchLbl;

    @FXML
    private ListView<Ticket> ticketView;

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

    private final Supplier<SceneManager> sceneManagerSupplier;
    private TicketManager ticketManager;
    private SystemUserManager systemUserManager;
    private SystemUser salesEmployee;

    public Ticket getSelectedTicket() {
        return selectedTicket;
    }

    private Ticket selectedTicket;

    public EditTicketController(Supplier<SceneManager> sceneManagerSupplier,SystemUser salesEmployee, SystemUserManager systemUserManager, TicketManager ticketManager){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.ticketManager = ticketManager;
        this.systemUserManager = systemUserManager;
        this.salesEmployee = salesEmployee;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Ticket> ticketList = ticketManager.getAll();
        if(ticketList != null) {
            ObservableList<Ticket> observableList = FXCollections.observableList(ticketList);
            ticketView.setItems(observableList);
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
            Ticket selected =  ticketView.getSelectionModel().getSelectedItem();
            this.selectedTicket = selected;

            sceneManagerSupplier.get().changeScene("editTicketData");

        }
    }

    @FXML
    void search(ActionEvent event) {

    }

}
