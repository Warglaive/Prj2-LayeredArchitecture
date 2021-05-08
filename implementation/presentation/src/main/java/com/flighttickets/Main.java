package com.flighttickets;

import com.flighttickets.BusinessLogic.BusinessLogicAPI;
import com.flighttickets.BusinessLogic.BusinessLogicImplementationProvider;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceImplementationProvider;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

public class Main {
    public static void main(String[] args) {

        PGDAOFactory daoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);
        PersistenceAPI persistenceAPI = PersistenceImplementationProvider.getImplementation(daoFactory);
        BusinessLogicAPI businesslogicAPI = BusinessLogicImplementationProvider.getImplementation(persistenceAPI);

        new App(businesslogicAPI).show();

    }
}
