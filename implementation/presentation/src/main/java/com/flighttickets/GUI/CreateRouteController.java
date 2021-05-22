
package com.flighttickets.GUI;

import com.flighttickets.Entities.Airport;
import com.flighttickets.Entities.AirportManager;
import com.flighttickets.Entities.RouteManager;
import com.flighttickets.Persistance.AirportStorageService;
import com.flighttickets.Persistance.RouteStorageService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class CreateRouteController implements Initializable {

    @FXML
    private ListView<Airport> airportsListSt;

    @FXML
    private ListView<Airport> airportsListDest;

    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    private final Supplier<SceneManager> sceneManagerSupplier;
    RouteManager routeManager;
    RouteStorageService routeStorageService;
    AirportManager airportManager;
    AirportStorageService airportStorageService;

    public CreateRouteController(Supplier<SceneManager> sceneManagerSupplier, RouteManager routeManager, RouteStorageService routeStorageService, AirportManager airportManager, AirportStorageService airportStorageService){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.routeManager = routeManager;
        this.routeStorageService = routeStorageService;
        this.airportManager = airportManager;
        this.airportStorageService = airportStorageService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void setAirportsListSt(){
        this.airportsListSt = (ListView<Airport>) FXCollections.observableArrayList();
        this.airportsListSt.setItems((ObservableList<Airport>) this.airportManager.getAirports());
    }

    @FXML
    private void setAirportsListDest(){
        this.airportsListDest = (ListView<Airport>) FXCollections.observableArrayList();
        this.airportsListDest.setItems((ObservableList<Airport>) this.airportManager.getAirports());
    }

    @FXML
    public void createRouteHandler(ActionEvent event) throws IOException {
        //this.airportsListSt.getSelectionModel().getSelectedItem();
        //this.airportsListDest.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("currentRoute");
    }

}

