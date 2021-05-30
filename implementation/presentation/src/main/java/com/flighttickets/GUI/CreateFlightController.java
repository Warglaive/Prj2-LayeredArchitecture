package com.flighttickets.GUI;

import com.flighttickets.Entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class CreateFlightController implements Initializable {

    @FXML
    private DatePicker datePicker;
    @FXML
    private TableView<Route> routesList;
    @FXML
    private TableView<Plane> planesList;
    @FXML
    private TableColumn routeIdCol;
    @FXML
    private TableColumn startIdCol;
    @FXML
    private TableColumn endIdCol;
    @FXML
    private TableColumn plannerIdCol;
    @FXML
    private TableColumn planeIdCol;
    @FXML
    private TableColumn registrationCol;
    @FXML
    private TableColumn brandCol;
    @FXML
    private TableColumn typeCol;
    @FXML
    private TableColumn seatsCol;
    @FXML
    private TableColumn legroomCol;
    @FXML
    private TableColumn firstClassCol;
    @FXML
    private TableView<Airport> airportsList;
    @FXML
    private TableColumn airportIdCol;
    @FXML
    private TableColumn airportNameCol;
    @FXML
    private TableColumn airportCountryCol;
    @FXML
    private TableColumn airportCityCol;
    /*
    @FXML
    private Button backButton;

    @FXML
    private Button SubmitButton;
    */

    private final Supplier<SceneManager> sceneManagerSupplier;
    private SystemUser planner;
    private PlaneManager planeManager;
    private RouteManager routeManager;
    private FlightManager flightManager;
    private AirportManager airportManager;

    public CreateFlightController(Supplier<SceneManager> sceneManagerSupplier, SystemUser planner, PlaneManager planeManager, RouteManager routeManager, FlightManager flightManager, AirportManager airportManager){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.planner = planner;
        this.planeManager = planeManager;
        this.routeManager = routeManager;
        this.flightManager = flightManager;
        this.airportManager = airportManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Route> listOfRoutes = this.routeManager.getByPlannerId(1);
        ObservableList<Route> observableList = FXCollections.observableList(listOfRoutes);
        this.routesList.setItems(observableList);
        this.routeIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.startIdCol.setCellValueFactory(new PropertyValueFactory<>("start_airport"));
        this.endIdCol.setCellValueFactory(new PropertyValueFactory<>("end_airport"));
        this.plannerIdCol.setCellValueFactory(new PropertyValueFactory<>("plannerId"));

        List<Plane> listOfPlanes = this.planeManager.getPlanes();
        ObservableList<Plane> observableList2 = FXCollections.observableList(listOfPlanes);
        this.planesList.setItems(observableList2);
        this.planeIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.registrationCol.setCellValueFactory(new PropertyValueFactory<>("registration"));
        this.brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        this.typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        this.seatsCol.setCellValueFactory(new PropertyValueFactory<>("seats_on_board"));
        this.legroomCol.setCellValueFactory(new PropertyValueFactory<>("extra_legroom_seats"));
        this.firstClassCol.setCellValueFactory(new PropertyValueFactory<>("first_class_seats"));

        List<Airport> listOfAirports = this.airportManager.getAirports();
        ObservableList<Airport> observableList3 = FXCollections.observableList(listOfAirports);
        this.airportsList.setItems(observableList3);
        this.airportIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.airportNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.airportCountryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        this.airportCityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("routesOverview");
    }

    @FXML
    public void submitHandler() throws SQLException, ClassNotFoundException {
        int newFlightId = 0;
        LocalDate localDate = this.datePicker.getValue();
        Route selectedRoute = this.routesList.getSelectionModel().getSelectedItem();
        int selectedRouteId = selectedRoute.getId();
        Plane selectedPlane = this.planesList.getSelectionModel().getSelectedItem();
        int selectedPlaneId = selectedPlane.getId();

        Flight createdFlight = new Flight(newFlightId, localDate, selectedRouteId, selectedPlaneId);
        this.flightManager.add(createdFlight);
        this.sceneManagerSupplier.get().changeScene("routesOverview");
    }
}