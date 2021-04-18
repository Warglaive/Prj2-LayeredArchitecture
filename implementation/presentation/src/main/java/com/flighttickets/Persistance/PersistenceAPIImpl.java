package com.flighttickets.Persistance;

public class PersistenceAPIImpl implements PersistenceAPI {
    @Override
    public CustomerStorageService getCustomerStorageService() {
        return new CustomerStorageService();
    }

    @Override
    public FlightStorageService getFlightStorageService() {
        return new FlightStorageService();
    }
}
