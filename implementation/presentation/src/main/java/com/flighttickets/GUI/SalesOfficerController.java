package com.flighttickets.GUI;

import com.flighttickets.Entities.SystemUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.function.Supplier;

public class SalesOfficerController {
    private final Supplier<SceneManager> sceneManagerSupplier;
    private SystemUser SalesOfficer;
    @FXML
    private Button managePlanesBtn;

    @FXML
    private Button editTicketBtn;

    @FXML
    private Button registerFlightBtn;

    @FXML
    private Button addTicketBtn;

    public SalesOfficerController(Supplier<SceneManager> sceneManagerSupplier, SystemUser salesOfficer) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.SalesOfficer = salesOfficer;
    }

    @FXML
    void addTicketScreen(ActionEvent event) {

        this.sceneManagerSupplier.get().changeScene("addTicket");
//        openStage("addTicket", "Add ticket", 612, 350);
    }

    @FXML
    void editTicketScreen(ActionEvent event) {
        this.sceneManagerSupplier.get().changeScene("editTicket");
//        openStage("editTicket", "Edit ticket", 802, 582);
    }

    @FXML
    void manageAirplaneScreen(ActionEvent event) {

    }

    @FXML
    void registerFlightScreen(ActionEvent event) {

    }

//    void openStage(String name, String title , int width, int height){
//        Parent root;
//        try {
//            root = FXMLLoader.load(GUIApp.class.getResource(name+".fxml"));
//            Stage stage = new Stage();
//            stage.setTitle(title);
//            stage.setScene(new Scene(root, width, height));
//            stage.show();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
