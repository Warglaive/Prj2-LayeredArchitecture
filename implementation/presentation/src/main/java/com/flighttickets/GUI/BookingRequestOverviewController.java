
package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class BookingRequestOverviewController implements Initializable {
    @FXML
    private Button back_btn;

    @FXML
    private Button decline_btn;

    @FXML
    private Button handle_btn;

    @FXML
    private ListView selection_list;

    private final Supplier<SceneManager> sceneManagerSupplier;
    private BookingRequestManager bookingRequestManager;
    private SystemUserManager systemUserManager;
    private SystemUser salesEmployee;

    public BookingRequestOverviewController(Supplier<SceneManager> sceneManagerSupplier,SystemUser salesEmployee, SystemUserManager systemUserManager, BookingRequestManager bookingRequestManager){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.bookingRequestManager = bookingRequestManager;
        this.systemUserManager = systemUserManager;
        this.salesEmployee = salesEmployee;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void declineRequestHandler(ActionEvent event) throws IOException {
        //GUIApp.setRoot("createRoute");
        System.out.println("Request has been declined");
    }

    @FXML
    public void handleRequestHandler(ActionEvent event) throws IOException {
        //GUIApp.setRoot("setPlane");
        System.out.println("Handle Request");
    }

    @FXML
    public void backHandler(ActionEvent event) throws IOException {
        this.sceneManagerSupplier.get().changeScene("main");
    }

}

