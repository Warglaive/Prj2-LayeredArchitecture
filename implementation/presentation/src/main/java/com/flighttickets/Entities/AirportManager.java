package com.flighttickets.Entities;

import com.flighttickets.Persistance.AirportStorageService;
import com.flighttickets.Persistance.PlaneStorageService;

import java.sql.SQLException;
import java.util.List;

public interface AirportManager {

    /**
     * @param name
     * @param country
     * @param city
     * @return Airport
     */

    /**
     * @param airport
     * @return Airport
     */
    void add(Airport airport) throws SQLException, ClassNotFoundException;

    /**
     * @param airportId
     * @return Airport
     */
    List<Route> getByPlaneId(int airportId);

    void setAirportStorageService(AirportStorageService airportStorageService);
}
