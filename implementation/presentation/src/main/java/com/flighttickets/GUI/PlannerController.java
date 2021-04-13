package com.flighttickets.GUI;

import com.flighttickets.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlannerController implements Initializable {

    @FXML
    private Button viewRoutesButton;

    @FXML
    private Button setPlaneToRouteButton;

    @FXML
    private Button backButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void viewRoutesHandler(ActionEvent event) throws IOException {
        App.setRoot("currentRoutes");
    }

    @FXML
    public void setPlaneHandler(ActionEvent event) throws IOException {
        App.setRoot("");
    }

    @FXML
    public void BackHandler(ActionEvent event) throws IOException {
        App.setRoot("login");
    }
}
