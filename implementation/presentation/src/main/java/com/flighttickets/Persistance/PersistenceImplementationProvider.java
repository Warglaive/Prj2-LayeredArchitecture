package com.flighttickets.Persistance;

import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

public interface PersistenceImplementationProvider extends PersistenceAPI{
    static PersistenceAPI getImplementation( PGDAOFactory daoFactory ){
        return new PersistenceAPIImpl(daoFactory);
    }
}
