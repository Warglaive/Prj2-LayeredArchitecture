package com.flighttickets.GUI;

import com.flighttickets.GUIApp;
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
    private Button addTicketBtn;

    @FXML
    void addTicketScreen(ActionEvent event) {
        openStage("addTicket", "Add ticket", 612, 350);
    }

    @FXML
    void editTicketScreen(ActionEvent event) {
        openStage("editTicket", "Edit ticket", 802, 582);
    }

    @FXML
    void manageAirplaneScreen(ActionEvent event) {

    }

    @FXML
    void registerFlightScreen(ActionEvent event) {

    }

    void openStage(String name, String title , int width, int height){
        Parent root;
        try {
            root = FXMLLoader.load(GUIApp.class.getResource(name+".fxml"));
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root, width, height));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
