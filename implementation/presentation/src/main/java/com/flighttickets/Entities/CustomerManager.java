package com.flighttickets.Entities;

import com.flighttickets.Persistance.CustomerStorageService;

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

    /**
     * setter for CustomerStorageService
     */
    void setCustomerStorageService(CustomerStorageService customerStorageService);
}
