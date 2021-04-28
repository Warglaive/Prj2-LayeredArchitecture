package com.flighttickets.Persistance;

import com.flighttickets.Entities.Route;
import com.flighttickets.Entities.RouteMapper;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.PGDataSource;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.util.List;

public class RouteStorageService {

    private final PGDAO<Integer, Route> routeDAO;
    private final String tableName = "route";
    private final String tableAirport = "airport";


    public RouteStorageService() {
        // Use the provided data source
        PGDAOFactory pdaof = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        pdaof.registerMapper(Route.class, new RouteMapper());
        // get a dao (no transactions yet).
        this.routeDAO = pdaof.createDao(Route.class);
    }

    public Route getRouteNames(){
        PGDAOFactory padof = new PGDAOFactory(PGDataSource.DATA_SOURCE);
        List<Route> routesList = this.routeDAO.anyQuery("SELECT name FROM " + tableAirport);
        return null;
    }

    /**
     * Save of Route
     *
     * @param Route
     */
    public void insert(Route Route) {
        this.routeDAO.save(Route);
    }

    public List<Route> getAll() {
        return this.routeDAO.getAll();
    }
}