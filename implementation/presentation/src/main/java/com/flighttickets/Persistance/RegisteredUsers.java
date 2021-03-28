package com.flighttickets.Persistance;

import com.flighttickets.Entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class RegisteredUsers {
    private final List<Customer> registered;

    /**
     * Create new list of customers
     */
    public RegisteredUsers() {
        this.registered = new ArrayList<>();
    }

    /**
     *
     * @param customer
     */
    public void add(Customer customer) {
        //TODO: Add safety
        this.registered.add(customer);
    }

    /**
     *
     * @return
     */
    public List<Customer> getAll() {
        return this.registered;
    }
}
