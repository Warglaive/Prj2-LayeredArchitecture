package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.*;
import com.flighttickets.Persistance.PersistenceAPI;

public class BusinessLogicAPIImpl implements BusinessLogicImplementationProvider, BusinessLogicAPI {

    final PersistenceAPI persistenceAPI;

    /**
     * assign PersistenceAPI on creation
     *
     * @param persistenceAPI provide connection to the persistence layer
     */
    public BusinessLogicAPIImpl(PersistenceAPI persistenceAPI) {
        this.persistenceAPI = persistenceAPI;
    }

    /**
     * Creates a customerManager
     *
     * @return new customer manager
     */
    @Override
    public SystemUserManager getSystemUserManager() {
        SystemUserManagerImpl systemUserManager = new SystemUserManagerImpl();
        systemUserManager.setSystemUserStorageService(this.persistenceAPI.getSystemUserStorageService());
        return systemUserManager;
    }

    @Override
    public BookingRequestManager getBookingRequestManager() {
        BookingRequestManager bookingRequestManager = new BookingRequestManagerImpl();
        bookingRequestManager.setBookingRequestStorageService(this.persistenceAPI.getBookingRequestStorageService());
        return bookingRequestManager;
    }

    @Override
    public BookingManager getBookingManager() {
        BookingManager bookingManager = new BookingManagerImpl();
        bookingManager.setBookingStorageService(this.persistenceAPI.getBookingStorageService());
        return bookingManager;
    }

    @Override
    public FlightManager getFlightManager() {
        FlightManagerImpl flightManager = new FlightManagerImpl();
        flightManager.setFlightStorageService(this.persistenceAPI.getFlightStorageService());
        return flightManager;
    }


    @Override
    public RouteManager getRouteManager() {
        RouteManagerImpl routeManager = new RouteManagerImpl();
        routeManager.setRouteStorageService(this.persistenceAPI.getRouteStorageService());
        return routeManager;
    }

    @Override
    public AirportManager getAirportManager() {
        AirportManagerImpl airportManager = new AirportManagerImpl();
        airportManager.setAirportStorageService(this.persistenceAPI.getAirportStorageService());
        return airportManager;
    }

    @Override
    public PlaneManager getPlaneManager(){
        PlaneManager planeManager = new PlaneManagerImpl();
        planeManager.setPlaneStorageService(this.persistenceAPI.getPlaneStorageService());
        return planeManager;
    }
  
    public TicketManager getTicketManager() {
        TicketManagerImpl ticketManager = new TicketManagerImpl();
        ticketManager.setTicketStorageService(this.persistenceAPI.getTicketStorageService());
        return ticketManager;
    }
}
