package com.flighttickets.BusinessLogic;
import com.flighttickets.Entities.Flight;
import com.flighttickets.Entities.FlightManager;
import com.flighttickets.Persistance.FlightStorageService;

import java.sql.SQLException;
import java.time.LocalDate;

public class FlightManagerImpl implements FlightManager {

    private FlightStorageService flightStorageService;

    @Override
    public Flight createFlight(int id, LocalDate date, int routeId, int planeId) {
        return new Flight(id, date, routeId, planeId);
    }

    @Override
    public void add(Flight flight) throws SQLException, ClassNotFoundException {
        this.flightStorageService.insert(flight);
    }

    @Override
    public void setFlightStorageService(FlightStorageService flightStorage) {
        this.flightStorageService = flightStorage;
    }

    @Override
    public FlightStorageService getFlightStorageService() {
        return this.flightStorageService;
    }
}
