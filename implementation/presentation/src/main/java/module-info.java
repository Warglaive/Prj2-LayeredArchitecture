module com.flighttickets {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.flighttickets to javafx.fxml;
    exports com.flighttickets;
}