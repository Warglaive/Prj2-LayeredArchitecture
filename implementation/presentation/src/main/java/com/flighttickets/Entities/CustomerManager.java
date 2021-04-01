package com.flighttickets.Entities;

public interface CustomerManager {
    /**
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param address
     * @return Customer
     */
    Customer createCustomer(String firstName, String lastName, String email, String password, String address);

    /**
     * @param customer
     * @return Customer
     */
    Customer add(Customer customer);
}
