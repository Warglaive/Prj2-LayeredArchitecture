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
    private String role;


    /**
     * create customer object
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param address
     * @param role
     */
    //TODO: Encrypt and add validation to each
    public CustomerImpl(String firstName, String lastName, String email, String password, String address, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
