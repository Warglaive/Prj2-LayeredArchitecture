package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.*;
import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceAPIImpl;
import com.flighttickets.Persistance.PersistenceImplementationProvider;
import com.flighttickets.Persistance.SystemUserStorageService;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

public class SystemUserManagerImplTest {


    private PGDAO<Integer, SystemUser> systemUserDAO;
    private final String tableName = "systemUser";

    private BusinessLogicAPI businesslogicAPI;
    private PersistenceAPI persistenceAPI;

    private SystemUserStorageService systemUserStorageService;

    private SystemUserManager systemUserManager;

@Test
    @BeforeEach
    void setUp() {
        PGDAOFactory daoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        daoFactory.registerMapper(SystemUser.class, new SystemUserMapper());
        // get a dao (no transactions yet).
        this.systemUserDAO = daoFactory.createDao(SystemUser.class);


        this.persistenceAPI=PersistenceImplementationProvider.getImplementation(daoFactory);
        this.businesslogicAPI = BusinessLogicImplementationProvider.getImplementation(persistenceAPI);


        this.systemUserStorageService = this.persistenceAPI.getSystemUserStorageService();
        this.systemUserManager = this.businesslogicAPI.getSystemUserManager();
        this.systemUserManager.setSystemUserStorageService(this.systemUserStorageService);
    }

    /**
     * test if setSystemUserStorageService sets StorageService properly with the help of getSystemUserStorageService helper method.
     */


    @Test
    void setSystemUserStorageService() {



        assertThat(this.systemUserManager.getSystemUserStorageService()).isExactlyInstanceOf(SystemUserStorageService.class);
    }

    /**
     * test if SystemUser object is properly created
     */

/*
    @Test
    void createSystemUserTest() {
        String firstName = "1";
        String lastName = "1";
        String email = "1";
        String password = "1";
        String address = "1";
        int level = 2;
        //Check if it is not null rather than .class
        assertThat(this.systemUserManager.createSystemUser(firstName, lastName, email, password, address, level))
                .isExactlyInstanceOf(SystemUser.class);
    }


    @Test
    void getByEmailTest() throws ClassNotFoundException, SQLException {
        String firstName = "1";
        String lastName = "1";
        String email = "1";
        String password = "1";
        String address = "1";
        int level = 2;
        //create new SystemUser
        SystemUser actual = this.systemUserManager.createSystemUser(firstName, lastName, email, password, address, level);
        //add SystemUser to Storage
        this.systemUserManager.add(actual);
        //get SystemUser
        String emailExpected = actual.getEmail();
        SystemUser expected = this.systemUserManager.getByEmail(emailExpected);
        //.usingRecursiveComparison()
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }


    @Test
    void addTest() throws ClassNotFoundException {
        String firstName = "1";
        String lastName = "1";
        String email = "1";
        String password = "1";
        String address = "1";
        int level = 2;
        //create new SystemUser
        SystemUser(actual = this.SystemUserManager.createSystemUser(firstName, lastName, email, password, address, level);
        //add SystemUser( to Storage
        this.SystemUserManager.add(actual);
        //get SystemUser
        String emailExpected = actual.getEmail();
        SystemUser expected = this.SystemUserManager.getByEmail(emailExpected);
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    void addTestException() throws ClassNotFoundException {
        String firstName = "1";
        String lastName = "1";
        String email = "1";
        String password = "1";
        String address = "1";
        int level = 2;
        //create new SystemUser
        SystemUser actual = this.SystemUserManager.createSystemUser(firstName, lastName, email, password, address, level);
        //add SystemUser to Storage
        this.SystemUserManager.add(actual);
        ThrowableAssert.ThrowingCallable code = () -> {
            String emailExpected = "nonExistentEmail";
            //get SystemUser
            SystemUser expected = this.SystemUserManager.getByEmail(emailExpected);

        };
        assertThatThrownBy(code).isExactlyInstanceOf(ClassNotFoundException.class).hasMessage("No SystemUser with such email address");

    }
    //TODO: add test for login method*/
}
