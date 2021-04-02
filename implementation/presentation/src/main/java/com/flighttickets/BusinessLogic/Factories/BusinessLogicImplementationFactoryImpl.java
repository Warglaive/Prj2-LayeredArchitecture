package com.flighttickets.BusinessLogic.Factories;

import com.flighttickets.BusinessLogic.BusinessLogicAPIImpl;
import com.flighttickets.Persistance.PersistenceAPI;

public class BusinessLogicImplementationFactoryImpl implements BusinessLogicImplementationFactory {
    @Override
    public BusinessLogicAPIImpl getBusinessLogicImpl(PersistenceAPI persistenceAPI) {
        return new BusinessLogicAPIImpl(persistenceAPI);
    }
}
