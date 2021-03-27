package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;

public class CustomerImpl implements Customer {
    String firstName;
    String lastName;
    String email;
    String password;
    String address;

    @Override
    public void register(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        //TODO: Encrypt
        this.password = password;
        this.address = address;
    }
}
