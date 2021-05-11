package com.flighttickets.GUI;

import com.flighttickets.GUIApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {

    private final Scene scene;
    private final Callback<Class<?>, Object> controllerFactory;
    private final Map< String, Parent> views = new HashMap<>();

    public SceneManager(Callback<Class<?>, Object> controllerFactory, String initialView ) {
        this.controllerFactory = controllerFactory;
        scene = new Scene( loadScene( initialView ) );
    }

    public final void changeScene(String view) {
        scene.setRoot( views.computeIfAbsent(view, v -> loadScene(v)) );
    }

    private Parent loadScene(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(GUIApp.class.getResource(fxml + ".fxml"));
        fxmlLoader.setControllerFactory(controllerFactory);
        try {
            return fxmlLoader.load();
        } catch (IOException ex) {
            return null;
        }
    }

    public void displayOn(Stage stage, int width, int height) {
        stage.setScene(scene);
        stage.setWidth( width );
        stage.setHeight( height );
        stage.show();
    }
}
