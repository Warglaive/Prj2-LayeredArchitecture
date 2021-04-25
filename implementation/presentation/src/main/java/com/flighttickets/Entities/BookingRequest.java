package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

public class BookingRequest implements Entity2<Integer> {
@ID
   private Integer bookingId;

    @Override
    public Integer getNaturalId() {
        return null;
    }

    @Override
    public int getId() {
        return 0;
    }
}
