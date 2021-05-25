package com.flighttickets.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class BookingRequestHandleController implements Initializable {

    @FXML
    private Button back_btn;

    @FXML
    private Label bookingRequest_id_label;

    private final Supplier<SceneManager> sceneManagerSupplier;

    public BookingRequestHandleController(Supplier<SceneManager> sceneManagerSupplier){
        this.sceneManagerSupplier = sceneManagerSupplier;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
