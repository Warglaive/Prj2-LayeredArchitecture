package com.flighttickets.Persistance;


import com.flighttickets.Entities.Flight;
import com.flighttickets.Entities.FlightMapper;
import com.flighttickets.PGDataSource;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

public class FlightStorageService {

    /**
     * Save a Route object to the database using a DataAccessObject
     * @param flight
     */
    public void insert(Flight flight) {
        // Use the provided data source
        PGDAOFactory pdaof = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        pdaof.registerMapper(Flight.class, new FlightMapper());
        // get a dao (no transactions yet).
        PGDAO<Integer, Flight> flightDAO = pdaof.createDao(Flight.class);
        flightDAO.save(flight);
    }

    public Flight retrieve(int id){//TODO: implementation
        throw new UnsupportedOperationException();
    }
}
