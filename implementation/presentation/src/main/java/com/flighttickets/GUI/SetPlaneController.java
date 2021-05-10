package com.flighttickets.GUI;

import com.flighttickets.App;
import com.flighttickets.Entities.*;
import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.AirportStorageService;
import com.flighttickets.Persistance.PlaneStorageService;
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

public class SetPlaneController implements Initializable {

    @FXML
    private ListView planesList;

    @FXML
    private Label selectedRouteLabel;

    @FXML
    private Button backButton;

    @FXML
    private Button SubmitButton;

    PlaneStorageService planeStorageService;
    PlaneManager planeManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void setPlanesList(){
        List<Plane> listOfPlanes = this.planeManager.getPlanes();
        ObservableList<Plane> observableList = FXCollections.observableList(listOfPlanes);
        planesList.setItems(observableList);
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        App.setRoot("currentRoutes");
    }

    @FXML
    public void submitHandler(){

    }
}
    //ObservableList<String> routes = FXCollections.observableArrayList();
    //Pass into the routemanager the planner id.. -JL
    //List<Route> listOfRoutes = this.routeManager.getByPlannerId(1);
    //Convert list into observableList
    //ObservableList<Route> observableList = FXCollections.observableList(listOfRoutes);
      //  routesList.setItems(observableList);