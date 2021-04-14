package com.flighttickets.GUI;

import com.flighttickets.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateRouteController implements Initializable {

    @FXML
    private TextField startLocation;

    @FXML
    private TextField endLocation;

    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public boolean validate() {
        if(startLocation.getText().isEmpty() || endLocation.getText().isEmpty() || startLocation.getText().length() < 3 || endLocation.getText().length() < 3){
            return false;
        } else {
            return true;
        }
    }

    @FXML
    public void createRouteHandler(ActionEvent event) throws IOException {
        String startPoint = startLocation.getText();
        String endPoint = endLocation.getText();
        String route = startPoint + " to" + endPoint;
        ObservableList<String> addRoute = FXCollections.observableArrayList();
        addRoute.addAll(route);
    }

    @FXML
    public void backButtonHandler(ActionEvent event) throws IOException {
        App.setRoot("currentRoutes");
    }

}
