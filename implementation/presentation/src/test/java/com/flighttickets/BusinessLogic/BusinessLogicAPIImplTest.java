package com.flighttickets.BusinessLogic;

import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceAPIImpl;
import com.flighttickets.Persistance.SystemUserStorageService;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class BusinessLogicAPIImplTest {

    //  PersistenceAPI persistenceAPIProviderSpy;


    @Test
    @BeforeEach
    void setUp() {
        //get new dataSource and instantiate DAO factory
        PGDAOFactory pgdaoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);
        //train mocked persistence provider to provide corresponding storage services
        //SystemUserStorageService
        // When you use the spy then the real methods are called (unless a method was stubbed).

        PersistenceAPIImpl PersistenceAPI = new PersistenceAPIImpl(pgdaoFactory);

      //  PersistenceAPIImpl PersistenceAPISpy = new Mockito(PersistenceAPI.getClass());


     /*   when(PersistenceAPISpy.getSystemUserStorageService())
                .thenReturn(new SystemUserStorageService(pgdaoFactory));*/
        //Booking requestStorageService
    }

    @Test
    void systemUserStorageServiceProvidedTest() {
    /*    var actual = this.persistenceAPIProviderSpy.getSystemUserStorageService();
        assertThat(actual)
                .isExactlyInstanceOf(SystemUserStorageService.class);*/
    }
}
