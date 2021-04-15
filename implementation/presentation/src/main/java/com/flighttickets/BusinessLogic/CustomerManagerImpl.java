package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageService;
import javafx.fxml.FXML;

public class CustomerManagerImpl implements CustomerManager {

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
    public Customer createCustomer(String firstName, String lastName, String email, String password, String address, String role) {
        return new CustomerImpl(firstName, lastName, email, password, address, role);
    }

    //TODO: Why not void
    @Override
    public Customer add(Customer customer) {
        this.customerStorageService.dataAccessObject.insert(customer);
        return customer;
    }

    public Customer getByEmail(String email) throws ClassNotFoundException {
        //TODO: Implement
        return null;
    }

    @FXML
    public Customer login(String email, String password) throws ClassNotFoundException {
        //TODO: Implement
        return null;
    }
}
