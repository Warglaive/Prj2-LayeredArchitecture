package com.flighttickets.BusinessLogic.Factories;

import com.flighttickets.BusinessLogic.BusinessLogicAPIImpl;
import com.flighttickets.Persistance.PersistenceAPI;

public interface BusinessLogicImplementationFactory {
    BusinessLogicAPIImpl getBusinessLogicImpl(PersistenceAPI persistenceAPI);

}
