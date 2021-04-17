package com.flighttickets.Persistance;


import com.flighttickets.Entities.Customer;
import nl.fontys.sebivenlo.dao.pg.PGDAO;

import static com.flighttickets.App.pdaof;

public class CustomerStorageService {

    /**
     * Save a Customer object to the database
     * @param customer
     */
    public void insert(Customer customer) {
        PGDAO<Integer, Customer> customerDAO = pdaof.createDao(Customer.class);
        customerDAO.save(customer);
    }
}
