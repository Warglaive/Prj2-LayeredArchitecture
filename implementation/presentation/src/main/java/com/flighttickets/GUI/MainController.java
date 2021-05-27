package com.flighttickets.GUI;

import com.flighttickets.Entities.SystemUserManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.function.Supplier;

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
    void showLogin() {
        this.sceneManagerSupplier.get().changeScene("Login");
    }

    @FXML
    void showRegister() {
        this.sceneManagerSupplier.get().changeScene("Register");
    }

}
