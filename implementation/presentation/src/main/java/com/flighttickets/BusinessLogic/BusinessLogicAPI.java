package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.FlightManager;
import com.flighttickets.Entities.SystemUserManager;

public interface BusinessLogicAPI {

    SystemUserManager getSystemUserManager();

    FlightManager getFlightManager();
}
