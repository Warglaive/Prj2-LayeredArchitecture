package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingRequestManager;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class CustomerMainViewController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;

    public CustomerMainViewController(Supplier<SceneManager> sceneManagerSupplier, BookingRequestManager bookingRequestManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
