package com.flighttickets;

import com.flighttickets.Entities.BusinessLogicAPI;
import com.flighttickets.Entities.BusinessLogicImplementationProvider;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceImplementationProvider;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

public class Main {
    public static void main(String[] args) {

        try {
            PGDAOFactory daoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);
            PersistenceAPI persistenceAPI = PersistenceImplementationProvider.getImplementation(daoFactory);
            BusinessLogicAPI businesslogicAPI = BusinessLogicImplementationProvider.getImplementation(persistenceAPI);

            new GUIApp(businesslogicAPI).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
