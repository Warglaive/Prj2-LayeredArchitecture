package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.AbstractMapper;

import java.util.function.Function;

public class FlightMapper extends AbstractMapper<Integer, Flight> {
    /**
     * Create a mapper for entity and key type.
     */
    public FlightMapper() {
        super(Integer.class, Flight.class);
    }

    @Override
    public Object[] explode(Flight e) {
        return e.asParts();
    }

    @Override
    public Function<Flight, Integer> keyExtractor() {
        return Flight::getId;
    }

    @Override
    public String tableName() {
        return "flight";
    }
}
