
package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class BookingRequestOverviewController implements Initializable {
    @FXML
    private Button back_btn;


    @FXML
    private Button handle_btn;

    @FXML
    private Label alert_label;

    @FXML
    private TableView<BookingRequest> selection_list;

    @FXML
    private TableColumn<BookingRequest, String> request_id_column;

    @FXML
    private TableColumn<BookingRequest, String> customer_id_column;

    @FXML
    private TableColumn<BookingRequest, String> departure_column;

    @FXML
    private TableColumn<BookingRequest, String> arrival_column;

    @FXML
    private TableColumn<BookingRequest, String> departure_date_column;

    @FXML
    private TableColumn<BookingRequest, String> return_date_column;

    @FXML
    private TableColumn<BookingRequest, String> passenger_count_column;



    private final Supplier<SceneManager> sceneManagerSupplier;
    private BookingRequestManager bookingRequestManager;
    //TODO Implement movement of EmployeeToHandleRequest - JL
    private SystemUserManager systemUserManager;
    private SystemUser salesEmployee;

    public BookingRequestOverviewController(Supplier<SceneManager> sceneManagerSupplier,SystemUser salesEmployee, SystemUserManager systemUserManager, BookingRequestManager bookingRequestManager){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.bookingRequestManager = bookingRequestManager;
        this.systemUserManager = systemUserManager;
        this.salesEmployee = salesEmployee;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Retrieves booking requests pending from the booking request manager. -jl
        List<BookingRequest> pendingRequests = this.bookingRequestManager.getPendingRequests();
        //Sets them all into an observable list - JL
        ObservableList<BookingRequest> observableList = FXCollections.observableList(pendingRequests);

        selection_list.setItems(observableList);
        request_id_column.setCellValueFactory(new PropertyValueFactory<BookingRequest, String>("id"));
        customer_id_column.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        departure_column.setCellValueFactory(new PropertyValueFactory<>("departureDestination"));
        arrival_column.setCellValueFactory(new PropertyValueFactory<>("arrivalDestination"));
        departure_date_column.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
        return_date_column.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        passenger_count_column.setCellValueFactory(new PropertyValueFactory<>("passengersAmount"));
    }


    @FXML
    public void handleRequestHandler(ActionEvent event) throws IOException {
        //GUIApp.setRoot("setPlane");
        if(selection_list.getSelectionModel().getSelectedItem() == null){
            alert_label.setText("Please select a request first!");
        } else {
            this.sceneManagerSupplier.get().changeScene("BookingRequestHandle");
        }
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("main");
    }

    public BookingRequest getSelectedBookingRequest(){
        BookingRequest tobeHandled = selection_list.getSelectionModel().getSelectedItem();
        //Returns so it can be used in the next scene - JL
        return tobeHandled;
    }

}

