package com.flighttickets.Entities;

import com.flighttickets.Persistance.CustomerStorageService;

public interface CustomerManager {
    /**
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param address
     * @param level
     * @return Customer
     */
    Customer createCustomer(String firstName, String lastName, String email, String password, String address, int level);

    /**
     * @param customer
     * @return Customer
     */
    Customer add(Customer customer);

    /**
     * @param password,email
     * @return Customer
     */
    int getUser(String email, String password);

    /**
     * setter for CustomerStorageService
     */
    void setCustomerStorageService(CustomerStorageService customerStorageService);
}
