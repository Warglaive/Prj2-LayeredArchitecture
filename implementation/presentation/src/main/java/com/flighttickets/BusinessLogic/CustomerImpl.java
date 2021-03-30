package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Persistance.RegisteredUsers;

public class CustomerImpl implements Customer {
    /**
     * Fields to be used to encrypt pass, validate names etc.
     */
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    RegisteredUsers registeredUsers;

    /**
     * create customer object
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param address
     */
    public CustomerImpl(String firstName, String lastName, String email, String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        //TODO: Encrypt
        this.password = password;
        this.address = address;


        this.registeredUsers = new RegisteredUsers();
        registeredUsers.add(this);
    }
}
