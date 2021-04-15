package com.flighttickets.Entities;
import nl.fontys.sebivenlo.dao.AbstractMapper;

import java.util.function.Function;

public class CustomerMapper extends AbstractMapper<Integer,Customer> {
    /**
     * Create a mapper for entity and key type.
     *
     * @param keyType    for key
     * @param entityType for entity
     */
    public CustomerMapper(Class<Integer> keyType, Class<Customer> entityType) {
        super(keyType, entityType);
    }

    @Override
    public Function<Customer, Integer> keyExtractor() {
        return Customer::getId;
    }
}
