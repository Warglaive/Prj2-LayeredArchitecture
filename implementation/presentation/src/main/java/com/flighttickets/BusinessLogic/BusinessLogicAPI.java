package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.*;

public interface BusinessLogicAPI {

    SystemUserManager getSystemUserManager();

    FlightManager getFlightManager();

    BookingRequestManager getBookingRequestManager();

    RouteManager getRouteManager();

    AirportManager getAirportManager();

    PlaneManager getPlaneManager();
}
