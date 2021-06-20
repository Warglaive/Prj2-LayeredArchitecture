package com.flighttickets.GUI;

import com.flighttickets.Entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class CreateRouteController implements Initializable {

    @FXML
    private TableView<Airport> airportsListSt;
    @FXML
    private TableView<Airport> airportsListDest;
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn nameCol;
    @FXML
    private TableColumn cityCol;
    @FXML
    private TableColumn countryCol;
    @FXML
    private TableColumn idCol1;
    @FXML
    private TableColumn nameCol1;
    @FXML
    private TableColumn cityCol1;
    @FXML
    private TableColumn countryCol1;
    @FXML
    private Label labelFail;

    /*
    @FXML
    private Button backButton;
    @FXML
    private Button submitButton;
     */

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

        this.idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        this.cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));

        this.idCol1.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nameCol1.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.countryCol1.setCellValueFactory(new PropertyValueFactory<>("country"));
        this.cityCol1.setCellValueFactory(new PropertyValueFactory<>("city"));
    }

    @FXML
    public void createRouteHandler(ActionEvent event) throws IOException {
        Integer initialId = 0;
        Airport starting = airportsListSt.getSelectionModel().getSelectedItem();
        Integer startingId = starting.getId();
        Airport endPoint = airportsListDest.getSelectionModel().getSelectedItem();
        Integer endId = endPoint.getId();
        Integer idPlanner = this.planner.getId();
        if(startingId != endId) {
            Route route = new Route(initialId, startingId, endId, idPlanner);
            this.routeManager.add(route);
            this.sceneManagerSupplier.get().changeScene("currentRoutes");
        } else {
            labelFail.setText("Start and end airport cannot be same!");
        }
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("currentRoutes");
    }
}