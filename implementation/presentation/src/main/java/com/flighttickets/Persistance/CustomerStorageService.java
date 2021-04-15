package com.flighttickets.Persistance;


import nl.fontys.sebivenlo.dao.DAO;

public class CustomerStorageService {
    public DAO dataAccessObject;

    public CustomerStorageService() {
        this.dataAccessObject = new CustomerDAO();
    }
}
