package com.flighttickets;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SalesOfficerController {

    @FXML
    private Button managePlanesBtn;

    @FXML
    private Button editTicketBtn;

    @FXML
    private Button registerFlightBtn;

    @FXML
    void editTicketScreen(ActionEvent event) {
        openStage("editTicket");
    }

    @FXML
    void manageAirplaneScreen(ActionEvent event) {

    }

    @FXML
    void registerFlightScreen(ActionEvent event) {

    }

    void openStage(String name){
        Parent root;
        try {
            root = FXMLLoader.load(App.class.getResource(name+".fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 802, 582));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
