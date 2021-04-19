package com.flighttickets.Persistance;


import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerMapper;
import com.flighttickets.PGDataSource;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.util.List;
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
        //Try to get an customer by its ID
        //Customer c = customerDAO.get(1).get();
        //TODO This works as soon as database name for customer_id is changed to customerid -JL
        List<Customer> customerList = customerDAO.anyQuery("SELECT * FROM customer WHERE email= '"+email+"' and password= '"+password+"' ");
        //Test if an actual customer is found
        //System.out.println("The customers found is = " + customerList.size());
        //If statement looks if one customer is found. More customers by the same email or 0 customers will result in a fail
        if(customerList.size() == 1) {
            return customerList.get(0);
        } else {
            System.out.println("No Customer found by that Email/Pass");
            //Implement error for user trying to login
            return null;
        }
    }
}
