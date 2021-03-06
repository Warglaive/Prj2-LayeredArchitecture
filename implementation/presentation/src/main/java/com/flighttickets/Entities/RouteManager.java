package com.flighttickets.Entities;

import com.flighttickets.Persistance.RouteStorageService;

import java.sql.SQLException;
import java.util.List;

public interface RouteManager {
    /**
     * @param start_airport
     * @param end_airport
     * @param plannerId
     * @return Route
     */

    Route createRoute(int id, int start_airport, int end_airport, int plannerId );

    /**
     * @param route
     * @return Route
     */
    void add(Route route);

    /**
     * @param plannerId
     * @return Route
     */
    List<Route> getByPlannerId(int plannerId);

    void setRouteStorageService(RouteStorageService routeStorageService);
}
