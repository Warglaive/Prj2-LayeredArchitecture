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
    public Customer(int id, String firstName, String lastName, String email, String password, String address, String role) {
        //No validation for input here, because it messes up the Mapping
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role;
    }

    /**
     * needed for the Mapper
     *
     * @return
     */
    @Override
    public Integer getNaturalId() {
        return this.id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    /**
     * needed for the Mapper
     *
     * @return
     */
    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
                + email + ", password=" + password + ", address=" + address
                + ", role=" + role + '}';
    }

    /**
     * needed for the Mapper
     *
     * @param parts
     * @return
     */
    static Customer fromParts(Object[] parts) {
        return new Customer((Integer) parts[0], (String) parts[1], (String) parts[2], (String) parts[3], (String) parts[4], (String) parts[5],
                (String) parts[6]);
    }

    /**
     * needed for the Mapper
     *
     * @return
     */
    Object[] asParts() {

        return new Object[]{
                this.id,
                this.firstName,
                this.lastName,
                this.email,
                this.password,
                this.address,
                this.role
        };
    }

    /**
     * Getters and setters for each field
     */
    public void setId(int id) {
        this.id = id;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
