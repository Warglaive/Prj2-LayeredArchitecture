package com.flighttickets;


import com.flighttickets.BusinessLogic.BusinessLogicAPI;
import com.flighttickets.GUI.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

/**
 * JavaFX GUIApp
 */
public class GUIApp extends Application {

    private BusinessLogicAPI businessLogicAPI;
    private SceneManager sceneManager;
    private static final String INITIAL_VIEW = "main";

    /**
     * instantiate controller so I can take the logged in user when changing views
     */
    private SystemUserController systemUserController;

    /**
     * Need controller for ticket too, to get the current ticket. Don't know another way to do it.
     */
    EditTicketController editTicketController;
    /**
     * instantiate controller so I can take the selected BkRequest when changing views
     */
    BookingRequestOverviewController bookingRequestOverviewController;


    /**
     * Add arguments for each Controller, EntityManager
     */
    private final Callback<Class<?>, Object> controllerFactory = (Class<?> c)
            -> {
        switch (c.getName()) {
            case "com.flighttickets.GUI.MainController":
                return new MainController(this::getSceneManager, this.businessLogicAPI.getSystemUserManager());
            case "com.flighttickets.GUI.SalesOfficerController":
                return new SalesOfficerController(this::getSceneManager, this.systemUserController.getLoggedInCustomer());
            case "com.flighttickets.GUI.CreateBookingRequestController":
                return new CreateBookingRequestController(this::getSceneManager, this.systemUserController.getLoggedInCustomer(), this.businessLogicAPI.getBookingRequestManager(), this.businessLogicAPI.getSystemUserManager());
            case "com.flighttickets.GUI.SystemUserController":
                this.systemUserController = new SystemUserController(this::getSceneManager, this.businessLogicAPI.getSystemUserManager(), this.businessLogicAPI.getBookingRequestManager());
                return this.systemUserController;
            case "com.flighttickets.GUI.BookingRequestOverviewController":
              this.bookingRequestOverviewController = new BookingRequestOverviewController(this::getSceneManager, this.systemUserController.getLoggedInCustomer(), this.businessLogicAPI.getSystemUserManager(), this.businessLogicAPI.getBookingRequestManager());
                return this.bookingRequestOverviewController;

            case "com.flighttickets.GUI.RouteController":
                return new RouteController(this::getSceneManager, this.systemUserController.getLoggedInCustomer(), this.businessLogicAPI.getRouteManager());
            case "com.flighttickets.GUI.CreateRouteController":
                return new CreateRouteController(this::getSceneManager, this.systemUserController.getLoggedInCustomer(), this.businessLogicAPI.getRouteManager(), this.businessLogicAPI.getAirportManager());
            case "com.flighttickets.GUI.CreateFlightController":
                return new CreateFlightController(this::getSceneManager, this.systemUserController.getLoggedInCustomer(), this.businessLogicAPI.getPlaneManager(), this.businessLogicAPI.getRouteManager(), this.businessLogicAPI.getFlightManager(), this.businessLogicAPI.getAirportManager());
            case "com.flighttickets.GUI.EditTicketController":
                this.editTicketController =  new EditTicketController(this::getSceneManager, this.systemUserController.getLoggedInCustomer(), this.businessLogicAPI.getSystemUserManager(), this.businessLogicAPI.getTicketManager());
                return this.editTicketController;
            case "com.flighttickets.GUI.EditTicketDataController":
                return new EditTicketDataController(this::getSceneManager, this.systemUserController.getLoggedInCustomer(), this.businessLogicAPI.getTicketManager(), this.editTicketController.getSelectedTicket());
            case "com.flighttickets.GUI.BookingRequestHandleController":
                return new BookingRequestHandleController(this::getSceneManager, this.bookingRequestOverviewController.getSelectedBookingRequest(), this.businessLogicAPI.getBookingManager());
            case "com.flighttickets.GUI.CustomerMainViewController":
                return new CustomerMainViewController(this::getSceneManager, this.systemUserController.getLoggedInCustomer(), this.businessLogicAPI.getBookingRequestManager());
            case "com.flighttickets.GUI.AllBookingRequestsController":
                return new AllBookingRequestsController(this::getSceneManager, this.systemUserController.getLoggedInCustomer(), this.businessLogicAPI.getBookingRequestManager(), this.businessLogicAPI.getSystemUserManager());

            //TODO: Add proper Default switch case
            default:
                return new MainController(this::getSceneManager, this.businessLogicAPI.getSystemUserManager());
        }
    };

    public GUIApp(BusinessLogicAPI businessLogicAPI) {
        this.businessLogicAPI = businessLogicAPI;
    }

    public GUIApp() {

    }

    public GUIApp show() {
        return init(true);
    }

    GUIApp init(boolean startJavaFXToolkit) {

        if (startJavaFXToolkit) {

            Platform.startup(() -> {
            });

            initializeSceneManager();

            Platform.runLater(() -> {
                Stage stage = new Stage();
                try {
                    start(stage);
                } catch (IOException ex) {
                    throw new IllegalStateException(ex);
                }
            });

        } else {
            initializeSceneManager();
        }

        return this;
    }

    private void initializeSceneManager() {
        sceneManager = new SceneManager(controllerFactory, INITIAL_VIEW);
    }

    @Override
    public void start(Stage stage) throws IOException {
        sceneManager.displayOn(stage, 640, 480);
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }

}