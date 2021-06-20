package com.flighttickets.BusinessLogic;

import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.PersistenceAPIImpl;
import com.flighttickets.Persistance.SystemUserStorageService;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class PersistenceAPIImplTest {

    @Mock
    PersistenceAPIImpl persistenceAPI;
    PGDAOFactory pgdaoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);


    @Test
    @BeforeEach
    void setUp() {
      //  this.persistenceAPI = (PersistenceAPIImpl) Mockito.doCallRealMethod(this.persistenceAPI.getSystemUserStorageService());
    }

    @Test
    void systemUserStorageServiceProvidedTest() {

        var expected = new SystemUserStorageService(pgdaoFactory);
        doReturn(expected).when(this.persistenceAPI.getSystemUserStorageService());
    }
}
