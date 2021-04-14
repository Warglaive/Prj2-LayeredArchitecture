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

public class CurrentRouteController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Button createRouteButton;

    @FXML
    private ListView routesList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> routes = FXCollections.observableArrayList();
        routes.add("Berlin to Munich");
        routesList.setItems(routes);
    }

    @FXML
    public void createRouteHandler(ActionEvent event) throws IOException {
        App.setRoot("createRoute");
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        App.setRoot("plannerMain");
    }

}
