
package com.flighttickets.GUI;

import com.flighttickets.Entities.Airport;
import com.flighttickets.Entities.Plane;
import com.flighttickets.Entities.PlaneManager;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.GUIApp;
import com.flighttickets.Persistance.PlaneStorageService;
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

public class SetPlaneController implements Initializable {

    @FXML
    private ListView<Plane> planesList;

    @FXML
    private Label selectedRouteLabel;

    @FXML
    private Button backButton;

    @FXML
    private Button SubmitButton;

    private final Supplier<SceneManager> sceneManagerSupplier;
    private SystemUser planner;
    private PlaneManager planeManager;

    public SetPlaneController(Supplier<SceneManager> sceneManagerSupplier, SystemUser planner, PlaneManager planeManager){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.planner = planner;
        this.planeManager = planeManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Plane> listOfPlanes = this.planeManager.getPlanes();
        ObservableList<Plane> observableList = FXCollections.observableList(listOfPlanes);
        this.planesList.setItems(observableList);
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("currentRoutes");
    }

    @FXML
    public void submitHandler(){
        
    }
}