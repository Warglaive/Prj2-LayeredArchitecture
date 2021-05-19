
package com.flighttickets.GUI;

import com.flighttickets.Entities.*;
import com.flighttickets.GUIApp;
import com.flighttickets.Persistance.AirportStorageService;
import com.flighttickets.Persistance.RouteStorageService;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
    AirportManager airportManager;
    SystemUser planner;

    public CreateRouteController(Supplier<SceneManager> sceneManagerSupplier, SystemUser planner, RouteManager routeManager, AirportManager airportManager){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.planner = planner;
        this.routeManager = routeManager;
        this.airportManager = airportManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Airport> listOfAirports = this.airportManager.getAirports();
        ObservableList<Airport> observableList = FXCollections.observableList(listOfAirports);
        this.airportsListSt.setItems(observableList);
        this.airportsListDest.setItems(observableList);
    }

    @FXML
    public void createRouteHandler(ActionEvent event) throws IOException {
        ObservableList<Airport> startPoint;
        startPoint = airportsListSt.getSelectionModel().getSelectedItems();

        ObservableList<Airport> endPoint;
        endPoint = airportsListDest.getSelectionModel().getSelectedItems();
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("currentRoutes");
    }
}

