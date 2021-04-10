package com.flighttickets;


import com.flighttickets.BusinessLogic.BusinessLogicAPI;
import com.flighttickets.BusinessLogic.BusinessLogicAPIImpl;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceAPIImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

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

    public static void main(String[] args) {
        launch(args);
    }

}