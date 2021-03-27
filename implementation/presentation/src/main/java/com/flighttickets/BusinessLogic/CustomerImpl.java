package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Persistance.RegisteredUsers;

public class CustomerImpl implements Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    RegisteredUsers registeredUsers;

    public CustomerImpl(String firstName, String lastName, String email, String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        //TODO: Encrypt
        this.password = password;
        this.address = address;


        this.registeredUsers = new RegisteredUsers();
        registeredUsers.add(new CustomerImpl(firstName, lastName, email, password, address));
    }
}
