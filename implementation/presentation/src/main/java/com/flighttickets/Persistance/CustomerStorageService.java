package com.flighttickets.Persistance;

import com.flighttickets.Entities.CustomerDAO;
import com.flighttickets.Entities.DAO;

public class CustomerStorageService {
    DAO dataAccessObject;

    public CustomerStorageService() {
        this.dataAccessObject = new CustomerDAO();
    }
}
