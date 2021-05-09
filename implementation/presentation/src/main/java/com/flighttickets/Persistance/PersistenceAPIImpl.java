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

    @Override
    public RouteStorageService getRouteStorageService() { return new RouteStorageService();}

    @Override
    public PlaneStorageService getPlaneStorageService() { return new PlaneStorageService();}

    @Override
    public AirportStorageService getAirportStorageService() { return new AirportStorageService();}
}
