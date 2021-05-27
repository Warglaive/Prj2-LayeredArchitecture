package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.AbstractMapper;

import java.util.function.Function;

public class BookingMapper extends AbstractMapper<Integer, Booking> {


    public BookingMapper() {
        super(Integer.class, Booking.class);
    }

    @Override
    public Object[] explode(Booking e){return e.asParts(); }

    @Override
    public Function<Booking, Integer> keyExtractor() {
        return Booking::getId;
    }

    @Override
    public String tableName(){ return "booking"; }
}
