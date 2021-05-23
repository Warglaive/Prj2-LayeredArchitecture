package com.flighttickets.GUI;

import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Entities.SystemUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CustomerMainViewController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;
    private SystemUser loggedInCustomer;
    private final BookingRequestManager bookingRequestManager;
    public Button logoutBtn;

    @FXML
    private TitledPane titledPane;

    @FXML
    private Button newBookingRequestBtn;

    @FXML
    private Button viewAllBookingRequestsBtn;

    @FXML
    private Text hiNameText;

    public CustomerMainViewController(Supplier<SceneManager> sceneManagerSupplier, SystemUser loggedInCustomer, BookingRequestManager bookingRequestManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.loggedInCustomer = loggedInCustomer;
        this.bookingRequestManager = bookingRequestManager;
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.hiNameText.setText(this.loggedInCustomer.getFirstName());
    }

    @FXML
    void viewAllBookingRequests() {
        //TODO: Implement
        this.sceneManagerSupplier.get().changeScene("AllBookingRequests");
    }

    @FXML
    void viewBookingRequestCreation() {
        this.sceneManagerSupplier.get().changeScene("CreateBookingRequest");
    }

    @FXML
    public void exitApp() throws FileNotFoundException, InterruptedException {
        //
        Stage stage = new Stage();
        //Creating an image
        Image image = new Image(new FileInputStream("src/main/resources/mp4/3cd.gif"));

        //Setting the image view
        ImageView imageView = new ImageView(image);

        //Setting the position of the image
        imageView.setX(50);
        imageView.setY(25);

        //setting the fit height and width of the image view
        imageView.setFitHeight(455);
        imageView.setFitWidth(500);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        //Creating a Group object
        Group root = new Group(imageView);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 500);

        //Setting title to the Stage
        stage.setTitle("Come again :)");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
        this.sceneManagerSupplier.get().changeScene("Main");
        //System.exit(0);
    }
}
