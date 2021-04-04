package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageService;

import java.util.ArrayList;
import java.util.List;

public class CustomerManagerImpl implements CustomerManager {

    private CustomerStorageService customerStorageService;


    public void setCustomerStorageService(CustomerStorageService customerStorageService) {
        this.customerStorageService = customerStorageService;
    }

    //TODO: Why not void
    @Override
    public Customer add(Customer customer) {
        this.customerStorageService.add(customer);
        return customer;
    }

    @Override
    public int getUser(String email, String password) {
        //List<Customer> customerList = this.customerStorageService.getAll();
        return 1;
    }

    @Override
    public Customer createCustomer(String firstName, String lastName, String email, String password, String address, int level) {
        return new CustomerImpl(firstName, lastName, email, password, address, level);
    }
}
