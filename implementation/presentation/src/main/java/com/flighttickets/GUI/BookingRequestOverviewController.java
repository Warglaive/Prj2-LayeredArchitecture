package com.flighttickets.GUI;

import com.flighttickets.App;
import com.flighttickets.Entities.Route;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookingRequestOverviewController implements Initializable {
    @FXML
    private Button back_btn;

    @FXML
    private Button decline_btn;

    @FXML
    private Button handle_btn;

    @FXML
    private ListView selection_list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void declineRequestHandler(ActionEvent event) throws IOException {
        //App.setRoot("createRoute");
        System.out.println("Request has been declined");
    }

    @FXML
    public void handleRequestHandler(ActionEvent event) throws IOException {
        //App.setRoot("setPlane");
        System.out.println("Handle Request");
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

}
