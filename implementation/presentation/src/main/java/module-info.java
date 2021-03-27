module com.flighttickets {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.flighttickets;
    opens com.flighttickets to javafx.fxml;
    exports com.flighttickets.GUI;
    opens com.flighttickets.GUI to javafx.fxml;
}