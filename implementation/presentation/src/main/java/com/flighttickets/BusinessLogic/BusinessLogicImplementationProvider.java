package com.flighttickets.BusinessLogic;

import com.flighttickets.Persistance.PersistenceAPI;

public interface BusinessLogicImplementationProvider extends BusinessLogicAPI {
    static BusinessLogicAPI getImplementation(PersistenceAPI persistenceAPI) {
        return new BusinessLogicAPIImpl(persistenceAPI);
    }
}
