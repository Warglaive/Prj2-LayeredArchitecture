package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.AbstractMapper;

import java.util.function.Function;

public class RouteMapper extends AbstractMapper<Integer, Route> {
    /**
     * Create a mapper for entity and key type.
     */
    public RouteMapper() {
        super(Integer.class, Route.class);
    }

    @Override
    public Object[] explode(Route e) {
        return e.asParts();
    }

    @Override
    public Function<Route, Integer> keyExtractor() {
        return Route::getId;
    }

    @Override
    public String tableName() {
        return "route";
    }
}
