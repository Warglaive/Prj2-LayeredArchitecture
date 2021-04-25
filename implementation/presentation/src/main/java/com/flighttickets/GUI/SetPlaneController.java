package com.flighttickets.GUI;

import com.flighttickets.App;
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

public class SetPlaneController implements Initializable {

    @FXML
    private ListView planesList;

    @FXML
    private Label selectedRouteLabel;

    @FXML
    private Button backButton;

    @FXML
    private Button SubmitButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void setPlanesList(){

    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        App.setRoot("createRoute");
    }

    @FXML
    public void submitHandler(){

    }
}
