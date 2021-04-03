package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.CustomerStorageService;

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
    public Customer get(String email, String password) {
        List<Customer> customerList = this.customerStorageService.getAll();
        //for (customerList.)
        //return list of customers with this username/password
        return null;
    }

    @Override
    public Customer createCustomer(String firstName, String lastName, String email, String password, String address) {
        return new CustomerImpl(firstName, lastName, email, password, address);
    }
}
