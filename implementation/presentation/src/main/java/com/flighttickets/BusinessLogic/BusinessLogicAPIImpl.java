package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Persistance.PersistenceAPI;

public class BusinessLogicAPIImpl implements BusinessLogicAPI {

    final PersistenceAPI persistenceAPI;

    public BusinessLogicAPIImpl(PersistenceAPI persistenceAPI) {
        this.persistenceAPI = persistenceAPI;
    }

    @Override
    public CustomerManager getCustomerManager() {
        CustomerManagerImpl customerManager = new CustomerManagerImpl();
        customerManager.setCustomerStorageService(this.persistenceAPI.getCustomerStorageService(customerManager));
        return customerManager;
    }
}
