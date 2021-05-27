
package com.flighttickets.GUI;

import com.flighttickets.BusinessLogic.BusinessLogicAPI;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Entities.*;
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
    private ListView routesList;

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
        List<Route> listOfRoutes = this.routeManager.getByPlannerId(1);
        ObservableList<Route> observableList = FXCollections.observableList(listOfRoutes);
        routesList.setItems(observableList);
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
