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
     * @param email
     * @return Customer
     */
    Customer getByEmail(String email) throws ClassNotFoundException;

    /**
     * setter for CustomerStorageService
     */
    void setCustomerStorageService(CustomerStorageService customerStorageService);
    CustomerStorageService getCustomerStorageService();
    Customer login(String email, String password) throws ClassNotFoundException;
}
