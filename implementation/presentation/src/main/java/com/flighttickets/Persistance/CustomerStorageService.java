package com.flighttickets.Persistance;

import com.flighttickets.Entities.CustomerDAO;

public class CustomerStorageService {
    public DAO dataAccessObject;

    public CustomerStorageService() {
        this.dataAccessObject = new CustomerDAO();
    }
}
