package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Route;
import com.flighttickets.Entities.RouteManager;
import com.flighttickets.Persistance.RouteStorageService;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class RouteManagerImpl implements RouteManager {

    private RouteStorageService routeStorageService;

    public void setRouteStorageService(RouteStorageService routeStorageService) {
        this.routeStorageService = routeStorageService;
    }

    /**
     * Test helper method
     *
     * @return
     */
    public RouteStorageService getRouteStorageService() {
        return routeStorageService;
    }

    @Override
    public Route createRoute(int id, int start_airport, int end_airport, int plannerId) {
        return new Route(id, start_airport, end_airport, plannerId);
    }

    @Override
    public void add(Route route) throws SQLException, ClassNotFoundException {
        this.routeStorageService.insert(route);
    }

    @Override
    public List<Route> getByPlannerId(int plannerId) {
        return this.routeStorageService.getRoutes(plannerId);
    }

}

