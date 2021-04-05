package com.flighttickets.Persistance;

import com.flighttickets.Entities.Customer;
import com.flighttickets.Entities.CustomerManager;

import java.util.ArrayList;
import java.util.List;

public class CustomerStorageServiceImpl implements CustomerStorageService {


    private final CustomerManager customerManager;
    private final List<Customer> registered;

    public CustomerStorageServiceImpl(CustomerManager customerManager) {
        this.registered = new ArrayList<>();

        this.customerManager = customerManager;
    }

    /**
     * @param customer Add customer to list of registeredCustomers
     */
    @Override
    public void add(Customer customer) {
        this.registered.add(customer);
    }

    @Override
    public List<Customer> getAll() {
        /**
         *   DB handling, returns resultSet
         *   for each entry in resultSet, make customer object using factory method in CustomerManager.
         *   For now, simulate DB result:
         */
        return this.registered;
    }

    @Override
    public Customer getByEmail(String email) {
        return (Customer) this.registered.stream().filter(x -> x.getEmail().equals(email));
    }
}
