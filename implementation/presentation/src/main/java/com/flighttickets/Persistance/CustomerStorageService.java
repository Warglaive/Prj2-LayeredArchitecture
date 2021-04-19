package com.flighttickets.Persistance;


import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerMapper;
import com.flighttickets.PGDataSource;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.util.Optional;

public class CustomerStorageService {

    private final PGDAO<Integer, Customer> customerDAO;

    public CustomerStorageService() {
        // Use the provided data source
        PGDAOFactory pdaof = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        pdaof.registerMapper(Customer.class, new CustomerMapper());
        // get a dao (no transactions yet).
        this.customerDAO = pdaof.createDao(Customer.class);
    }

    /**
     * Save a Customer object to the database using a DataAccessObject
     *
     * @param customer
     */
    public void insert(Customer customer) {
        this.customerDAO.save(customer);
    }

    public Customer retrieve(String email, String password) {
        Optional<Customer> c = this.customerDAO.get(1);
        //TODO Query inserted above using customerDAO.anyQuery(here) - JL
        Customer toBeLoggedIn = c.get();
        //Customer toBeLoggedIn = new Customer(1,"jasper","lastname",email,password,"Mook", "SalesOfficer");
        return toBeLoggedIn;

        //TODO This works as soon as database name for customer_id is changed to customerid -JL

    }
}
