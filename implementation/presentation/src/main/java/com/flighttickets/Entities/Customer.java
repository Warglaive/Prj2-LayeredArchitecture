package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

public class Customer implements Entity2<Integer> {

    @ID(generated = true)
    int id;
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
    public Customer(String firstName, String lastName, String email, String password, String address, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role;
    }

    @Override
    public Integer getNaturalId() {
        return this.id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        //TODO: Implement
        throw new UnsupportedOperationException();
    }

    static Customer fromParts(Object[] parts) {
        return new Customer((String) parts[0], (String) parts[1], (String) parts[2], (String) parts[3], (String) parts[4],
                (String) parts[5]);
    }

    Object[] asParts() {

        return new Object[]{
                this.firstName,
                this.lastName,
                this.email,
                this.password,
                this.address,
                this.role
        };
    }
}
