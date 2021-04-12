package com.flighttickets.Persistance;

import com.flighttickets.Entities.CustomerManager;

public class PersistenceAPIImpl implements PersistenceAPI {
    @Override
    public CustomerStorageService getCustomerStorageService() {
        return new CustomerStorageServiceImpl();
    }
}
