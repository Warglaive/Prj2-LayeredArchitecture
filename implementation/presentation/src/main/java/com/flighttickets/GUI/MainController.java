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
    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    public MainController(Supplier<SceneManager> sceneManagerSupplier, SystemUserManager SystemUserManager) {
        this.loginBtn = new Button();
        this.registerBtn = new Button();
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.SystemUserManager = SystemUserManager;
    }


    @FXML
    void showLogin() throws IOException {
        this.sceneManagerSupplier.get().changeScene("login");
    }

    @FXML
    void showRegister() throws IOException {
        this.sceneManagerSupplier.get().changeScene("register");
    }

}
