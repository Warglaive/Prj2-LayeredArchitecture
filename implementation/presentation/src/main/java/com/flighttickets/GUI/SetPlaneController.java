
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
    private PlaneStorageService planeStorageService;

    public SetPlaneController(Supplier<SceneManager> sceneManagerSupplier, SystemUser planner, PlaneManager planeManager){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.planner = planner;
        this.planeManager = planeManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void setPlanesList(){
        this.planesList = (ListView<Plane>) FXCollections.observableArrayList();
        this.planesList.setItems((ObservableList<Plane>) this.planeManager.getPlanes());
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("createRoute");
    }

    @FXML
    public void submitHandler(){
        
    }
}