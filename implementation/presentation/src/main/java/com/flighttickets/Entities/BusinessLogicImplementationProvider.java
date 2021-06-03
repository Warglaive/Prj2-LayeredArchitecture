package com.flighttickets.Entities;

import com.flighttickets.BusinessLogic.BusinessLogicAPIImpl;
import com.flighttickets.Persistance.PersistenceAPI;

public interface BusinessLogicImplementationProvider extends BusinessLogicAPI {
    /**
     * static method to be used everywhere
     *
     * @param persistenceAPI - connection to persistence layer
     * @return BusinessLogicAPI
     */
    static BusinessLogicAPI getImplementation(PersistenceAPI persistenceAPI) {
        return new BusinessLogicAPIImpl(persistenceAPI);
    }
}
