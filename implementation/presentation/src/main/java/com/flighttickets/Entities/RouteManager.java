package com.flighttickets.Entities;

import java.sql.SQLException;

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
    void add(Route route) throws SQLException, ClassNotFoundException;

    /**
     * @param plannerId
     * @return Route
     */
    Route getByPlannerId(String plannerId) throws ClassNotFoundException;
}
