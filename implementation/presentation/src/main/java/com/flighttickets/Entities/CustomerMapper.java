package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.AbstractMapper;

import java.util.function.Function;

public class CustomerMapper extends AbstractMapper<Integer, Customer> {
    /**
     * Create a mapper for entity and key type.
     */
    public CustomerMapper() {
        super(Integer.class, Customer.class);
    }

    @Override
    public Object[] explode(Customer e) {
        return e.asParts();
    }

    @Override
    public Function<Customer, Integer> keyExtractor() {
        return Customer::getId;
    }

    @Override
    public String tableName() {
        return "customer";
    }
}
