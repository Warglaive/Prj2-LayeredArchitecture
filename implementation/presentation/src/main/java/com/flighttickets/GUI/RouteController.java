package com.flighttickets.GUI;

import com.flighttickets.Entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class RouteController implements Initializable {

    /*
    @FXML
    private Button backButton;
    @FXML
    private Button createRouteButton;
    @FXML
    private Button createFlightButton;
    */

    @FXML
    private TableView routesList;
    @FXML
    private TableColumn routeIdCol;
    @FXML
    private TableColumn startIdCol;
    @FXML
    private TableColumn endIdCol;
    @FXML
    private TableColumn plannerIdCol;

    private RouteManager routeManager;
    private final Supplier<SceneManager> sceneManagerSupplier;
    private SystemUser planner;

    public RouteController(Supplier<SceneManager> sceneManagerSupplier, SystemUser planner, RouteManager routeManager){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.routeManager = routeManager;
        this.planner = planner;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Route> listOfRoutes = this.routeManager.getByPlannerId(this.planner.getId());
        ObservableList<Route> observableList = FXCollections.observableList(listOfRoutes);
        this.routesList.setItems(observableList);
        this.routeIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.startIdCol.setCellValueFactory(new PropertyValueFactory<>("start_airport"));
        this.endIdCol.setCellValueFactory(new PropertyValueFactory<>("end_airport"));
        this.plannerIdCol.setCellValueFactory(new PropertyValueFactory<>("plannerId"));
        /*
        List<Route> listOfRoutes = this.routeManager.getByPlannerId(this.planner.getId());
        ObservableList<Route> observableList = FXCollections.observableList(listOfRoutes);
        routesList.setItems(observableList);
         */
    }

    @FXML
    public void createRouteHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("createRoute");
    }

    @FXML
    public void createFlightHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("createFlight");
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("login");
    }
}
