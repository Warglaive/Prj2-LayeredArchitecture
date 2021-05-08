package com.flighttickets.GUI;

import java.io.IOException;
import java.util.function.Supplier;

import com.flighttickets.Entities.SystemUserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    private final Supplier<SceneManager> sceneManagerSupplier;
    private SystemUserManager SystemUserManager;

    public MainController(Supplier<SceneManager> sceneManagerSupplier, SystemUserManager SystemUserManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.SystemUserManager = SystemUserManager;
    }

    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    void showLogin(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("login");
    }

    @FXML
    void showRegister(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("register");
    }

}
