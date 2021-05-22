package com.flighttickets.Persistance;

import com.flighttickets.Entities.Airport;
import com.flighttickets.Entities.AirportMapper;
import com.flighttickets.PGDataSource;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.util.List;

public class AirportStorageService {

    private final PGDAO<Integer, Airport> airportDAO;
    private final String tableName = "airport";


    public AirportStorageService() {
        // Use the provided data source
        PGDAOFactory pdaof = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        pdaof.registerMapper(Airport.class, new AirportMapper());
        // get a dao (no transactions yet).
        this.airportDAO = pdaof.createDao(Airport.class);
    }

    public List<Airport> getAirports() {
        List<Airport> airportsList = this.airportDAO.anyQuery("SELECT * FROM " + this.tableName);
        //result was found
        System.out.println("Is a airport found?" + airportsList.get(0).toString());
        return airportsList;
    }

    /**
     * Save of Airport
     *
     * @param Airport
     */
    public void insert(Airport Airport) {
        this.airportDAO.save(Airport);
    }

    public List<Airport> getAll() {
        return this.airportDAO.getAll();
    }

}
