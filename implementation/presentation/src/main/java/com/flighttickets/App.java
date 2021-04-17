package com.flighttickets;


import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerMapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static PGDAOFactory pdaof = null;
    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        scene = new Scene(loadFXML("main"), 535, 440);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main view of Flights software");
        primaryStage.setResizable(true);
        primaryStage.show();


        // Use the provided data source
        PGDAOFactory pdaof = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        pdaof.registerMapper(Customer.class, new CustomerMapper());
        // get a dao (no transactions yet).
        PGDAO<Integer, Customer> customerDAO = pdaof.createDao(Customer.class);
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


  /*  public static final PGDAOFactory pdaof() {
        if (null == pdaof) {
            pdaof = new PGDAOFactory(PGDataSource.DATA_SOURCE);
        }
        return pdaof;
    }*/
}