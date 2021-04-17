module com.flighttickets {
    requires nl.fontys.sebidao;

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.sql.rowset;
    /*requires ojdbc10;*/
    requires org.postgresql.jdbc;

    exports com.flighttickets;
    opens com.flighttickets to javafx.fxml;
    exports com.flighttickets.GUI;
    opens com.flighttickets.GUI to javafx.fxml;

    exports com.flighttickets.Entities;
    opens com.flighttickets.Entities to javafx.fxml;

    exports com.flighttickets.BusinessLogic;
    opens com.flighttickets.BusinessLogic to javafx.fxml;


    exports com.flighttickets.Persistance;
    opens com.flighttickets.Persistance to javafx.fxml;

}
