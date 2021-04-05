package com.flighttickets.Persistance;

import com.flighttickets.Entities.Customer;

import java.util.List;

public interface CustomerStorageService {
    /**
     * add a Customer object to DB
     * @param customer
     */
    void add(Customer customer);

    /**
     * get all Customers from DB
     * @return
     */
    List<Customer> getAll();
    Customer getByEmail(String email);
}
