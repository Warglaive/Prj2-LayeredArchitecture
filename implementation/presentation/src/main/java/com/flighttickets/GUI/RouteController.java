package com.flighttickets.GUI;

import com.flighttickets.App;
import com.flighttickets.BusinessLogic.BusinessLogicAPI;
import com.flighttickets.BusinessLogic.BusinessLogicAPIImpl;
import com.flighttickets.Entities.Route;
import com.flighttickets.Entities.RouteManager;
import com.flighttickets.Entities.SystemUserManager;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceAPIImpl;
import com.flighttickets.Persistance.RouteStorageService;
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

public class RouteController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Button createRouteButton;

    @FXML
    private Button setPlaneButton;

    @FXML
    private ListView routesList;

    private RouteManager routeManager;
    private BusinessLogicAPI businessLogicAPI;
    private PersistenceAPI persistenceAPI;

    public RouteController(){
        this.persistenceAPI = new PersistenceAPIImpl();
        this.businessLogicAPI = new BusinessLogicAPIImpl(this.persistenceAPI);

        this.routeManager = this.businessLogicAPI.getRouteManager();
        this.routeManager.setRouteStorageService(new RouteStorageService());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //ObservableList<String> routes = FXCollections.observableArrayList();
        //Pass into the routemanager the planner id.. -JL
        List<Route> listOfRoutes = this.routeManager.getByPlannerId(1);
        //Convert list into observableList
        ObservableList<Route> observableList = FXCollections.observableList(listOfRoutes);
        routesList.setItems(observableList);
    }

    @FXML
    public void createRouteHandler(ActionEvent event) throws IOException {
        App.setRoot("createRoute");
    }

    @FXML
    public void setPlaneHandler(ActionEvent event) throws IOException {
        App.setRoot("setPlane");
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

}
