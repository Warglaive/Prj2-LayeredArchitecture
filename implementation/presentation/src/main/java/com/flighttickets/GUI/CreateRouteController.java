package com.flighttickets.GUI;

import com.flighttickets.App;
import com.flighttickets.Entities.Airport;
import com.flighttickets.Entities.AirportManager;
import com.flighttickets.Entities.Route;
import com.flighttickets.Entities.RouteManager;
import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.RouteStorageService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CreateRouteController implements Initializable {

    @FXML
    private ListView airportsListSt;

    @FXML
    private ListView airportsListDest;
    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    RouteManager routeManager;
    RouteStorageService routeStorageService;
    AirportManager airportManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void setAirportsListSt(){
        List<Airport> airportList = this.airportManager.getAirports();
        ObservableList<Airport> observableList = FXCollections.observableList(airportList);
        airportsListSt.setItems(observableList);
    }

    @FXML
    private void setAirportsListDest(){
        List<Airport> airportList = this.airportManager.getAirports();
        ObservableList<Airport> observableList = FXCollections.observableList(airportList);
        airportsListDest.setItems(observableList);
    }

    @FXML
    public void createRouteHandler(ActionEvent event) throws IOException {
        this.airportsListSt.getSelectionModel().getSelectedItem();
        this.airportsListDest.getSelectionModel().getSelectedItem();
    }

    public void backHandler(ActionEvent event) throws IOException {
        App.setRoot("currentRoutes");
    }
}
