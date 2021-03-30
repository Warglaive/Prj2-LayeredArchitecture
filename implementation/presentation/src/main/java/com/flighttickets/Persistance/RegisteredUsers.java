package com.flighttickets.Persistance;

import com.flighttickets.Entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class RegisteredUsers {
    private final List<Customer> registered;

    /**
     * Create new list of registered customers
     */
    public RegisteredUsers() {
        this.registered = new ArrayList<>();
    }

    /**
     *
     * @param customer
     * add customer to list of registered customers
     */
    public void add(Customer customer) {
        //TODO: Add safety
        this.registered.add(customer);
    }

    /**
     *
     * @return all already registered customers
     */
    public List<Customer> getAll() {
        return this.registered;
    }
}
