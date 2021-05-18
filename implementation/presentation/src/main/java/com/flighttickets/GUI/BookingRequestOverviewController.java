
package com.flighttickets.GUI;

import com.flighttickets.Entities.*;
import com.flighttickets.GUIApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class BookingRequestOverviewController implements Initializable {
    @FXML
    private Button back_btn;

    @FXML
    private Button decline_btn;

    @FXML
    private Button handle_btn;

    @FXML
    private TableView<BookingRequest> selection_list;



    private final Supplier<SceneManager> sceneManagerSupplier;
    private BookingRequestManager bookingRequestManager;
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
        List<BookingRequest> pendingRequests = this.bookingRequestManager.getPendingRequests();
        ObservableList<BookingRequest> observableList = FXCollections.observableList(pendingRequests);
        selection_list.setItems(observableList);
    }

    @FXML
    public void declineRequestHandler(ActionEvent event) throws IOException {
        //GUIApp.setRoot("createRoute");
        //BookingRequest declined = selection_list.getSelectionModel().getSelectedItem();
        System.out.println("Request has been declined");
    }

    @FXML
    public void handleRequestHandler(ActionEvent event) throws IOException {
        //GUIApp.setRoot("setPlane");
        System.out.println("Handle Request");
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("main");
    }

}

