package com.flighttickets.Persistance;

import com.flighttickets.Entities.Airport;
import com.flighttickets.Entities.AirportMapper;
import com.flighttickets.Entities.Plane;
import com.flighttickets.Entities.PlaneMapper;
import com.flighttickets.PGDataSource;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

public class AirportStorageService {

    private final PGDAO<Integer, Airport> airportDAO;
    private final String tableName = "aiport";


    public AirportStorageService() {
        // Use the provided data source
        PGDAOFactory pdaof = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        pdaof.registerMapper(Airport.class, new AirportMapper());
        // get a dao (no transactions yet).
        this.airportDAO = pdaof.createDao(Airport.class);
    }
}
