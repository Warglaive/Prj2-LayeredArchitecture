package com.flighttickets.Entities;

import com.flighttickets.Persistance.AirportStorageService;

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
     * @param
     * @return Airport
     */
    List<Airport> getAirports();

    Airport getAirport(int airportId);

    void setAirportStorageService(AirportStorageService airportStorageService);
    public AirportStorageService getAirportStorageService();
    public Airport createAirport(int id, String name, String country, String city);
}
