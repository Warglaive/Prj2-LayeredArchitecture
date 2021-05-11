package com.flighttickets.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EditTicketController {

    @FXML
    private TextField searchTbx;

    @FXML
    private Label searchLbl;

    @FXML
    private TableView<?> ticketTbl;

    @FXML
    private TableColumn<?, ?> ticketIdColumn;

    @FXML
    private TableColumn<?, ?> locationsColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private TableColumn<?, ?> discountColumn;

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

    }

    @FXML
    void search(ActionEvent event) {

    }

}
