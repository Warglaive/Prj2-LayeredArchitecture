package com.flighttickets.Persistance;

import com.flighttickets.Entities.Customer;

import java.util.List;

public class CustomerStorageServiceImpl implements CustomerStorageService {
    @Override
    public void add(Customer customer) {

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
