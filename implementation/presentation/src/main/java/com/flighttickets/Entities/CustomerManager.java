package com.flighttickets.Entities;

import com.flighttickets.Persistance.CustomerStorageService;

import java.sql.SQLException;

public interface CustomerManager {
    /**
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param address
     * @param role
     * @return Customer
     */
    Customer createCustomer(String firstName, String lastName, String email, String password, String address, String role);

    /**
     * @param customer
     * @return Customer
     */
    Customer add(Customer customer) throws SQLException, ClassNotFoundException;

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
