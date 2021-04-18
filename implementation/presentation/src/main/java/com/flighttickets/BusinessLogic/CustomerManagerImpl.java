package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageService;
import javafx.fxml.FXML;

import java.sql.SQLException;

public class CustomerManagerImpl implements CustomerManager {

    //TODO: Add validator class to validate user input
    //TODO: Add HashPassword method
    private CustomerStorageService customerStorageService;

    public void setCustomerStorageService(CustomerStorageService customerStorageService) {
        this.customerStorageService = customerStorageService;
    }

    /**
     * Test helper method
     *
     * @return
     */
    public CustomerStorageService getCustomerStorageService() {
        return customerStorageService;
    }

    @Override
    public Customer createCustomer(int id, String firstName, String lastName, String email, String password, String address, String role) {
        return new Customer(id, firstName, lastName, email, password, address, role);
    }

    /**
     * pass Customer to StorageService to be added into the DB
     * @param customer
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void add(Customer customer) throws SQLException, ClassNotFoundException {
        //TODO: Validate each property of Customer
        this.customerStorageService.insert(customer);
    }

    public Customer getByEmail(String email) throws ClassNotFoundException {
        //TODO: Implement
        return null;
    }

    @FXML
    public Customer login(String email, String password) throws ClassNotFoundException {
        //TODO: Implement -JL
        return this.customerStorageService.retrieve(email,password);
    }
}
