package com.flighttickets.Persistance;


import com.flighttickets.Entities.Airport;
import com.flighttickets.Entities.Flight;
import com.flighttickets.Entities.FlightMapper;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.util.List;

public class FlightStorageService {
    private PGDAO<Integer, Flight> flightDAO;

    public FlightStorageService(PGDAOFactory daoFactory) {
        daoFactory.registerMapper(Flight.class, new FlightMapper());
        // get a dao (no transactions yet).
        this.flightDAO = daoFactory.createDao(Flight.class);
    }

    /**
     * Save a Route object to the database using a DataAccessObject
     * @param flight
     */
    public void insert(Flight flight) {
        flightDAO.save(flight);
    }

    public Flight retrieve(int id){
        String query = "SELECT * FROM flight WHERE flightid = '"+id+"';";
        List<Flight> flights = flightDAO.anyQuery(query);
        if(flights.size() == 0)
            return null;
        return flights.get(0);

    }
    public List<Flight> getAll() {
        return this.flightDAO.getAll();
    }
}
