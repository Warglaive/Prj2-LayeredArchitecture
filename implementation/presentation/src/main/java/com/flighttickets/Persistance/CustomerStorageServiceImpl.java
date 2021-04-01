package com.flighttickets.Persistance;

import com.flighttickets.Entities.Customer;

import java.util.List;

public class CustomerStorageServiceImpl implements CustomerStorageService {

    private final List<Customer> registered;

    public CustomerStorageServiceImpl(List<Customer> registered) {
        this.registered = registered;
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
        return null;
    }
}
