package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;

public class CustomerImpl implements Customer {
    /**
     * Fields to be used to encrypt pass, validate names etc.
     */
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;

    /**
     * create customer object
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param address
     */
    //TODO: Encrypt and add validation to each
    public CustomerImpl(String firstName, String lastName, String email, String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        this.password = password;
        this.address = address;
    }
}
