package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.*;
import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceImplementationProvider;
import com.flighttickets.Persistance.RouteStorageService;
import com.flighttickets.Persistance.SystemUserStorageService;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RouteManagerImplTest {

    RouteManager routeManager;
    private PersistenceAPI persistenceAPI;
    private BusinessLogicAPI businesslogicAPI;
    private RouteStorageService routeStorageService;

    @BeforeEach
    void setUp() {
        PGDAOFactory daoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        daoFactory.registerMapper(Route.class, new RouteMapper());


        this.persistenceAPI = PersistenceImplementationProvider.getPersistenceImplementation(daoFactory);
        this.businesslogicAPI = BusinessLogicImplementationProvider.getImplementation(persistenceAPI);


        this.routeStorageService = this.persistenceAPI.getRouteStorageService();
        this.routeManager = this.businesslogicAPI.getRouteManager();
        //Set storageService
        this.routeManager.setRouteStorageService(this.routeStorageService);
    }

    @Test
    void setRouteStorageService() {
        Assertions.assertThat(this.routeManager.getRouteStorageService()).isExactlyInstanceOf(RouteStorageService.class);
    }

    @Test
    public void addRouteTest(){
        int routeId = 0;
        int airportFirst = 1;
        int airportSecond = 2;
        int plannerId = 4;
        Route route = this.routeManager.createRoute(routeId, airportFirst, airportSecond, plannerId);
        this.routeManager.add(route);
        List<Route> routes = this.routeManager.getByPlannerId(route.getPlannerId());
        //checking if start airport is the same
        assertThat(routes.get(routes.size()-1).getStart_airport()).isEqualTo(route.getStart_airport());
    }

    @Test
    public void getByRouteIdTest(){
        Route route = this.routeManager.getByRouteId(1);
        assertThat(route).isExactlyInstanceOf(Route.class);
    }

    
}
