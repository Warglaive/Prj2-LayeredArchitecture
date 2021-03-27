package com.flighttickets.Persistance;

import com.flighttickets.Entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class RegisteredUsers {
    private List<Customer> registered;

    void RegisteredUsers() {
        this.registered = new ArrayList<>();
    }

    public void add(Customer customer) {
        //TODO: Add safety

        this.registered.add(customer);
    }
}
