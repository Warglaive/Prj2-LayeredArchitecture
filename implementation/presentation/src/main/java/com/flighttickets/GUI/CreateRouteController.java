/*
package com.flighttickets.GUI;

import com.flighttickets.GUIApp;
import com.flighttickets.Entities.Route;
import com.flighttickets.Entities.RouteManager;
import com.flighttickets.Persistance.RouteStorageService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateRouteController implements Initializable {

    @FXML
    private ListView<Route> airportsListSt;

    @FXML
    private ListView<Route> airportsListDest;
    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    RouteManager routeManager;
    RouteStorageService routeStorageService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void setAirportsListSt(){
        this.airportsListSt = (ListView<Route>) FXCollections.observableArrayList();
        this.airportsListSt.setItems((ObservableList<Route>) routeStorageService.getAll());
    }

    private void setAirportsListDest(){
        this.airportsListDest = (ListView<Route>) FXCollections.observableArrayList();
        this.airportsListDest.setItems((ObservableList<Route>) routeStorageService.getAll());
    }

    @FXML
    public void createRouteHandler(ActionEvent event) throws IOException {
        this.airportsListSt.getSelectionModel().getSelectedItem();
        this.airportsListDest.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void backButtonHandler(ActionEvent event) throws IOException {
        GUIApp.setRoot("currentRoutes");
    }

}
*/
