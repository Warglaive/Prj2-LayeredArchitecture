package com.flighttickets.Persistance;


import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerMapper;
import com.flighttickets.PGDataSource;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import static com.flighttickets.App.pdaof;

public class CustomerStorageService {

    /**
     * Save a Customer object to the database
     * @param customer
     */
    public void insert(Customer customer) {
        // Use the provided data source
        PGDAOFactory pdaof = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        pdaof.registerMapper(Customer.class, new CustomerMapper());
        // get a dao (no transactions yet).
        PGDAO<Integer, Customer> customerDAO = pdaof.createDao(Customer.class);
        customerDAO.save(customer);
    }
}
