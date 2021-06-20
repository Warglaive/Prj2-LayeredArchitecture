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

    PGDAOFactory pgdaoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);


    @Mock
    PersistenceAPIImpl persistenceAPI = Mockito.mock(PersistenceAPIImpl.class);

    /**
     * mock persistenceAPI in order to test if storageServices are provided properly
     */
    @Test
    @BeforeEach
    void setUp() {

    }

    @Test
    void systemUserStorageServiceProvidedTest() {

        var expected = new SystemUserStorageService(pgdaoFactory);
        doReturn(expected).when(this.persistenceAPI.getSystemUserStorageService());
    }
}
