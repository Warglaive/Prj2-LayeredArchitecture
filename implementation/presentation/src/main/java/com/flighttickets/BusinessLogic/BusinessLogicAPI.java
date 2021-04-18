package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.CustomerManager;
import com.flighttickets.Entities.FlightManager;

public interface BusinessLogicAPI {
    CustomerManager getCustomerManager();

    FlightManager getFlightManager();
}
