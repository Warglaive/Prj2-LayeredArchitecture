package com.flighttickets.Persistance;

import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

public class PersistenceAPIImpl implements PersistenceImplementationProvider, PersistenceAPI {
    private final PGDAOFactory daoFactory;

    public PersistenceAPIImpl(PGDAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public SystemUserStorageService getSystemUserStorageService() {
        return new SystemUserStorageService(this.daoFactory);
    }

    @Override
    public FlightStorageService getFlightStorageService() {
        return new FlightStorageService(this.daoFactory);
    }

    @Override
    public BookingRequestStorageService getBookingRequestStorageService() {
        return new BookingRequestStorageService(this.daoFactory);
    }

    @Override
    public RouteStorageService getRouteStorageService() {
        return new RouteStorageService(this.daoFactory);
    }

    @Override
    public PlaneStorageService getPlaneStorageService() {
        return new PlaneStorageService(this.daoFactory);
    }

    @Override
    public AirportStorageService getAirportStorageService() {
        return null;
    }
}
