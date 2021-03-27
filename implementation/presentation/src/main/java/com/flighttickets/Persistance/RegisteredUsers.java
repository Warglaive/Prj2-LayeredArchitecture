package com.flighttickets.Persistance;

import com.flighttickets.Entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class RegisteredUsers {
    private List<Customer> registered;

    public RegisteredUsers() {
        this.registered = new ArrayList<>();
    }

    public void add(Customer customer) {
        //TODO: Add safety
        System.out.println("Add reached");
        this.registered.add(customer);
    }
}
