package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.AbstractMapper;

import java.util.function.Function;

public class PlaneMapper extends AbstractMapper<Integer, Plane> {

    /**
     * Create a mapper for entity and key type.
     */
    public PlaneMapper() {
        super(Integer.class, Plane.class);
    }

    @Override
    public Function<Plane, Integer> keyExtractor() { return Plane::getId;}

    @Override
    public Object[] explode(Plane e) {
        return e.asParts();
    }

    @Override
    public String tableName() {
        return "plane";
    }
}