package com.flighttickets.Entities;
import com.flighttickets.Persistance.FlightStorageService;

import java.sql.SQLException;
import java.time.LocalDate;

public interface FlightManager {
    /**
     * @param id
     * @param date the date of the flight
     * @param routeId The id of the route
     * @param planeId The id of the plane
     * @return flight
     */
    Flight createFlight(int id, LocalDate date, int routeId, int planeId);

    /**
     * @param flight the flight to add
     */
    void add(Flight flight) throws SQLException, ClassNotFoundException;

    /**
     * setter for FlightStorageService
     */
    void setFlightStorageService(FlightStorageService flightStorage);

    FlightStorageService getFlightStorageService();
}
