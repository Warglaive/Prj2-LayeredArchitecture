package com.flighttickets;

import com.flighttickets.BusinessLogic.BusinessLogicAPI;
import com.flighttickets.BusinessLogic.BusinessLogicImplementationProvider;
//import com.flighttickets.Entities.BusinessLogicAPI; If you didnt move the businesslogic api to businesslogic activate this - JL merge 21juni

import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceImplementationProvider;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

public class Main {
    public static void main(String[] args) {

        try {
            PGDAOFactory daoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);
            PersistenceAPI persistenceAPI = PersistenceImplementationProvider.getPersistenceImplementation(daoFactory);
            BusinessLogicAPI businesslogicAPI = BusinessLogicImplementationProvider.getImplementation(persistenceAPI);

            new GUIApp(businesslogicAPI).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
