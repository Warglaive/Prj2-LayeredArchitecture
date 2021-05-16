package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.AbstractMapper;

import java.util.function.Function;

public class BookingRequestMapper extends AbstractMapper<Integer, BookingRequest> {

    /**
     * Create a mapper for entity and key type.
     */
    public BookingRequestMapper() {
        super(Integer.class, BookingRequest.class);
    }

    @Override
    public Object[] explode(BookingRequest e) {
        return e.asParts();
    }

    @Override
    public Function<BookingRequest, Integer> keyExtractor() {
        return BookingRequest::getId;
    }

    @Override
    public String tableName() {
        return "bookingRequest";
    }
}
