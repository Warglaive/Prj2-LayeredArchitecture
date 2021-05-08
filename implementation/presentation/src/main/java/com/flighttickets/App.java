package com.flighttickets;


import com.flighttickets.BusinessLogic.BusinessLogicAPI;
import com.flighttickets.GUI.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private BusinessLogicAPI businessLogicAPI;
    private SceneManager sceneManager;


    public App(BusinessLogicAPI businesslogicAPI) {
        this.businessLogicAPI = businesslogicAPI;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        scene = new Scene(loadFXML("main"), 535, 440);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main view of Flights software");
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void show() {
    }


    /*public static void main(String[] args) {
        //TODO: Make use of the controller rather than "Launch"
        launch();
    }*/

}