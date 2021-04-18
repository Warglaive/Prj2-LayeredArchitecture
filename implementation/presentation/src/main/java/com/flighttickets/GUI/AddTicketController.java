package com.flighttickets.GUI;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
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
    private TextField startLocTbx;

    @FXML
    private TextField endLocTbx;

    @FXML
    private TextField priceTbx;

    @FXML
    private Button AddBtn;

    @FXML
    private Label startDateLbl;

    @FXML
    private Label startTimeLbl;

    @FXML
    private TextField startTimeTbx;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    void AddBtnHandler(ActionEvent event) {
        String startLocationStr = startLocTbx.getText();
        String endLocationStr = endLocTbx.getText();
        String priceStr = priceTbx.getText();

        if(priceStr.contains("€")){
            priceStr = priceStr.replace("€", "");
        }
        try {
            int price = Integer.parseInt(priceStr);
        }
        catch (NumberFormatException e){
            System.out.println("Error: "+e);
            //TODO: add error message for user
        }
        LocalDate startDate = startDatePicker.getValue();

        String startTime = startTimeTbx.getText();
        //currently no time in db, no need to check if this is a time. Also won't use the variable further


        
        
    }

    @FXML
    void initialize() {

    }
}
