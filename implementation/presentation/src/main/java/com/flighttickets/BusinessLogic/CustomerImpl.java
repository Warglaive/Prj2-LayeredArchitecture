package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;

public class CustomerImpl implements Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;


    @Override
    public void register(String firstName, String lastName, String email, String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        //TODO: Encrypt
        this.password = password;
        this.address = address;

        
    }
}
