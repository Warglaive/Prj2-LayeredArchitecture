package com.flighttickets.Entities;

public interface BusinessLogicAPI {

    SystemUserManager getSystemUserManager();

    FlightManager getFlightManager();

    BookingRequestManager getBookingRequestManager();

    BookingManager getBookingManager();

    RouteManager getRouteManager();

    AirportManager getAirportManager();

    PlaneManager getPlaneManager();

    TicketManager getTicketManager();
}
