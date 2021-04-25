package com.flighttickets.GUI;

import com.flighttickets.App;
import com.flighttickets.Entities.RouteManager;
import com.flighttickets.PGDataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.io.IOException;
import java.net.URL;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void setAirportsListSt(){
        this.airportsListSt = (ListView) FXCollections.observableArrayList();
        
    }

    private void setAirportsListDest(){
        this.airportsListDest = (ListView) FXCollections.observableArrayList();
    }

    @FXML
    public void createRouteHandler(ActionEvent event) throws IOException {
        this.airportsListSt.getSelectionModel().getSelectedItem();
        this.airportsListDest.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void backButtonHandler(ActionEvent event) throws IOException {
        App.setRoot("currentRoutes");
    }

}
