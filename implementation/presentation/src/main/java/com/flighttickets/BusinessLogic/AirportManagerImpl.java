package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Airport;
import com.flighttickets.Entities.AirportManager;
import com.flighttickets.Entities.Route;
import com.flighttickets.Persistance.AirportStorageService;
import com.flighttickets.Persistance.RouteStorageService;

import java.sql.SQLException;
import java.util.List;

public class AirportManagerImpl implements AirportManager {

    private AirportStorageService airportStorageService;

    public void setAirportStorageService(AirportStorageService airportStorageService) {
        this.airportStorageService = airportStorageService;
    }

    public Airport createAirport

    @Override
    public void add(Airport airport) throws SQLException, ClassNotFoundException {
        this.airportStorageService.insert(airport);
    }

    @Override
    public List<Route> getByPlaneId(int airportId) {
        return null;
    }
}
