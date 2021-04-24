package com.flighttickets.Persistance;

public class PersistenceAPIImpl implements PersistenceAPI {
    @Override
    public SystemUserStorageService getSystemUserStorageService() {
        return new SystemUserStorageService();
    }

    @Override
    public FlightStorageService getFlightStorageService() {
        return new FlightStorageService();
    }

    @Override
    public BookingRequestStorageService getBookingRequestStorageService() {
        return new BookingRequestStorageService();
    }
}
