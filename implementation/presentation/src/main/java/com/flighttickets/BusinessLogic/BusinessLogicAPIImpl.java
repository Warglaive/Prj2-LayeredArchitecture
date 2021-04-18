package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Entities.FlightManager;
import com.flighttickets.Persistance.PersistenceAPI;

public class BusinessLogicAPIImpl implements BusinessLogicAPI {

    final PersistenceAPI persistenceAPI;

    /**
     * assign PersistenceAPI on creation
     * @param persistenceAPI
     */
    public BusinessLogicAPIImpl(PersistenceAPI persistenceAPI) {
        this.persistenceAPI = persistenceAPI;
    }

    /**
     * Creates a customerManager
     * @return
     */
    @Override
    public CustomerManager getCustomerManager() {
        CustomerManagerImpl customerManager = new CustomerManagerImpl();
        customerManager.setCustomerStorageService(this.persistenceAPI.getCustomerStorageService());
        return customerManager;
    }

    @Override
    public FlightManager getFlightManager() {
        FlightManagerImpl flightManager = new FlightManagerImpl();
        flightManager.setFlightStorageService(this.persistenceAPI.getFlightStorageService());
        return flightManager;
    }
}
