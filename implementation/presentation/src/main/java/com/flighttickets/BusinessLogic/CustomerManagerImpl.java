package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageService;
import javafx.fxml.FXML;

import java.sql.SQLException;

public class CustomerManagerImpl implements CustomerManager {

    //TODO: Add validator class to validate user input
    RegisterInputValidator inputValidator;
    //TODO: Add HashPassword method
    private CustomerStorageService customerStorageService;

    public void setCustomerStorageService(CustomerStorageService customerStorageService) {
        this.customerStorageService = customerStorageService;
        this.inputValidator = new RegisterInputValidatorImpl();
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
        //TODO: Validate each property of Customer and throw CUSTOM exception if something is wrong.
        boolean isInputValid = this.inputValidator.isFirstNameValid(firstName);
        return new Customer(id, firstName, lastName, email, password, address, role);
    }

    /**
     * pass Customer to StorageService to be added into the DB
     *
     * @param customer
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void add(Customer customer) throws SQLException, ClassNotFoundException {
        this.customerStorageService.insert(customer);
    }

    public Customer getByEmail(String email) throws ClassNotFoundException {
        //TODO: Implement/See if its still needed - JL
        return null;
    }

    @FXML
    public Customer login(String email, String password) throws ClassNotFoundException {
        //Retrieves customer from database based on email, password -JL
        return this.customerStorageService.retrieve(email, password);
    }
}
