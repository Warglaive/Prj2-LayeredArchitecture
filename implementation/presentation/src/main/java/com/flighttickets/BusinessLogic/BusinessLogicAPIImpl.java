package com.flighttickets.BusinessLogic;
import com.flighttickets.Entities.FlightManager;
import com.flighttickets.Entities.SystemUserManager;
import com.flighttickets.Persistance.PersistenceAPI;

public class BusinessLogicAPIImpl implements BusinessLogicAPI {

    final PersistenceAPI persistenceAPI;

    /**
     * assign PersistenceAPI on creation
     * @param persistenceAPI
     */
    public BusinessLogicAPIImpl(PersistenceAPI persistenceAPI) {
        this.persistenceAPI = persistenceAPI;
    }

    /**
     * Creates a customerManager
     * @return
     */
    @Override
    public SystemUserManager getSystemUserManager() {
        SystemUserManagerImpl systemUserManager = new SystemUserManagerImpl();
        systemUserManager.setSystemUserStorageService(this.persistenceAPI.getSystemUserStorageService());
        return systemUserManager;
    }

    @Override
    public FlightManager getFlightManager() {
        FlightManagerImpl flightManager = new FlightManagerImpl();
        flightManager.setFlightStorageService(this.persistenceAPI.getFlightStorageService());
        return flightManager;
    }
}
