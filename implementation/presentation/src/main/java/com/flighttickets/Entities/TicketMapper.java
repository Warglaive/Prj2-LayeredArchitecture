package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.AbstractMapper;

import java.util.function.Function;

public class TicketMapper extends AbstractMapper<Integer, Ticket> {
    /**
     * Create a mapper for entity and key type.
     */
    public TicketMapper() {
        super(Integer.class, Ticket.class);
    }

    @Override
    public Object[] explode(Ticket e) {
        return e.asParts();
    }

    @Override
    public Function<Ticket, Integer> keyExtractor() {
        return Ticket::getId;
    }

    @Override
    public String tableName() {
        return "ticket";
    }
}
