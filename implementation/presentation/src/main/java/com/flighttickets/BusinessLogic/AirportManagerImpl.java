package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Airport;
import com.flighttickets.Entities.AirportManager;
import com.flighttickets.Persistance.AirportStorageService;

import java.sql.SQLException;
import java.util.List;

public class AirportManagerImpl implements AirportManager {

    private AirportStorageService airportStorageService;

    public void setAirportStorageService(AirportStorageService airportStorageService) {
        this.airportStorageService = airportStorageService;
    }

    public AirportStorageService getAirportStorageService() {
        return this.airportStorageService;
    }

    public Airport createAirport(int id, String name, String country, String city){
        return new Airport(id, name, country, city);
    }

    @Override
    public void add(Airport airport) throws SQLException, ClassNotFoundException {
        this.airportStorageService.insert(airport);
    }

    //@Override
    public List<Airport> getAirports() {
        return this.airportStorageService.getAirports();
    }
}
