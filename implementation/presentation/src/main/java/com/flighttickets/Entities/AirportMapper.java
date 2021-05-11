package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.AbstractMapper;

import java.util.function.Function;

public class AirportMapper extends AbstractMapper<Integer, Airport> {

    /**
     * Create a mapper for entity and key type.
     */
    public AirportMapper() {
        super(Integer.class, Airport.class);
    }

    @Override
    public Function<Airport, Integer> keyExtractor() { return Airport::getId; }

    //@Override
    public Object[] explode(Plane e) {
        return e.asParts();
    }

    @Override
    public String tableName() {
        return "airport";
    }
}
