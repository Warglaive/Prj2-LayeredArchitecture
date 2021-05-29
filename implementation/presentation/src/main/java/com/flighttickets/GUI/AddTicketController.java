/*
package com.flighttickets.GUI;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.flighttickets.Entities.BusinessLogicAPI;
import com.flighttickets.BusinessLogic.BusinessLogicAPIImpl;
import com.flighttickets.Entities.Flight;
import com.flighttickets.Entities.FlightManager;
import com.flighttickets.Persistance.FlightStorageService;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceAPIImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddTicketController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField RouteTbx;

    @FXML
    private TextField priceTbx;

    @FXML
    private Button AddBtn;

    @FXML
    private Label startDateLbl;

    @FXML
    private Label startTimeLbl;

    @FXML
    private Label RouteLbl;

    @FXML
    private TextField startTimeTbx;

    @FXML
    private DatePicker startDatePicker;

    BusinessLogicAPI businessLogicAPI;

    FlightManager flightManager;
    PersistenceAPI persistenceAPI;


    @FXML
    void AddBtnHandler(ActionEvent event) throws SQLException, ClassNotFoundException {
        int route;
        int price;
        String routeStr = RouteTbx.getText();
        try {
            route = Integer.parseInt(routeStr);
        }
        catch (NumberFormatException e){
            System.out.println("Error: "+e);
            return;
            //TODO: add error message for user
        }

        String priceStr = priceTbx.getText();

        if(priceStr.contains("€")){
            priceStr = priceStr.replace("€", "");
        }
        try {
            price = Integer.parseInt(priceStr);
        }
        catch (NumberFormatException e){
            System.out.println("Error: "+e);
            return;
            //TODO: add error message for user
        }
        LocalDate startDate = startDatePicker.getValue();

        String startTime = startTimeTbx.getText();
        //currently no time in db, no need to check if this is a time. Also won't use the variable further
        //TODO: add price for tickets, need to discuss about this -JT

        Flight flight = this.flightManager.createFlight(0, startDate, route, 1);

        this.flightManager.add(flight);


        
        
    }

    public AddTicketController(){
        this.persistenceAPI = new PersistenceAPIImpl();
        this.businessLogicAPI = new BusinessLogicAPIImpl(this.persistenceAPI);

        this.flightManager = this.businessLogicAPI.getFlightManager();
        this.flightManager.setFlightStorageService(new FlightStorageService());
    }

    @FXML
    void initialize() {

    }
}
*/
