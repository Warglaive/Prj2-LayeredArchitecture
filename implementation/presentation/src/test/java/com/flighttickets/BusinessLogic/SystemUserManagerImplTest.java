package com.flighttickets.BusinessLogic;

import com.flighttickets.BusinessLogic.Exceptions.InvalidInputException;
import com.flighttickets.BusinessLogic.Exceptions.SystemUserStorageException;
//import com.flighttickets.Entities.BusinessLogicAPI;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import com.flighttickets.Entities.SystemUserMapper;
import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceImplementationProvider;
import com.flighttickets.Persistance.SystemUserStorageService;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.security.auth.login.AccountNotFoundException;
import java.sql.SQLException;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SystemUserManagerImplTest {


    private BusinessLogicAPI businesslogicAPI;
    private PersistenceAPI persistenceAPI;

    private SystemUserStorageService systemUserStorageService;

    @Mock
    SystemUserStorageService systemUserStorageServiceMock = Mockito.mock(SystemUserStorageService.class);

    private SystemUserManager systemUserManager;


    /**
     * TEST HELPER Method
     * Generate random Email for test
     *
     * @return random Email
     */
    public String generateEmail() {
        String SALTCHARS = "AaBbCcDdEeF";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@gmail.com";
    }


    @BeforeEach
    void setUp() {
        PGDAOFactory daoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        daoFactory.registerMapper(SystemUser.class, new SystemUserMapper());


        this.persistenceAPI = PersistenceImplementationProvider.getPersistenceImplementation(daoFactory);
        this.businesslogicAPI = BusinessLogicImplementationProvider.getImplementation(persistenceAPI);


        this.systemUserStorageService = this.persistenceAPI.getSystemUserStorageService();
        this.systemUserManager = this.businesslogicAPI.getSystemUserManager();
        //Set storageService
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
     * test if SystemUser object is properly created only with valid input
     */
    @Test
    void createSystemUserValidTest() {
        int id = 1;
        String firstName = "Svetoslav";
        String lastName = "Stoyanov";
        String email = "valid@abv.bg";
        String password = "1ASD!x_asd";
        String address = "franciscanenstraat 10";
        String role = "Customer";
        //Check if it is not null rather than .class
        assertThat(this.systemUserManager.createSystemUser(id, firstName, lastName, email, password, address, role))
                .isExactlyInstanceOf(SystemUser.class);
    }

    /**
     * test if exception is thrown on invalid input
     */
    @Test
    void createSystemUserFirstNameInvalidTest() {
        int id = 1;
        String firstName = "123";
        String lastName = "Stoyanov";
        String email = "valid@abv.bg";
        String password = "1ASD!x_asd";
        String address = "franciscanenstraat 10";
        String role = "Customer";
        //Check if it is not null rather than .class

        ThrowableAssert.ThrowingCallable code = () -> {
            this.systemUserManager.createSystemUser(id, firstName, lastName, email, password, address, role);
        };

        assertThatCode(code).isExactlyInstanceOf(InvalidInputException.class).hasMessage("Invalid first name!");
    }

    /**
     * test if exception is thrown on invalid input
     */
    @Test
    void createSystemUserLastNameInvalidTest() {
        int id = 1;
        String firstName = "Svetoslav";
        String lastName = "123";
        String email = "valid@abv.bg";
        String password = "1ASD!x_asd";
        String address = "franciscanenstraat 10";
        String role = "Customer";
        //Check if it is not null rather than .class

        ThrowableAssert.ThrowingCallable code = () -> {
            this.systemUserManager.createSystemUser(id, firstName, lastName, email, password, address, role);
        };

        assertThatCode(code).isExactlyInstanceOf(InvalidInputException.class).hasMessage("Invalid last name!");
    }

    /**
     * test if exception is thrown on invalid input
     */
    @Test
    void createSystemUserEmailInvalidTest() {
        int id = 1;
        String firstName = "Svetoslav";
        String lastName = "Stoyanov";
        String email = "123";
        String password = "1ASD!x_asd";
        String address = "franciscanenstraat 10";
        String role = "Customer";
        //Check if it is not null rather than .class

        ThrowableAssert.ThrowingCallable code = () -> {
            this.systemUserManager.createSystemUser(id, firstName, lastName, email, password, address, role);
        };

        assertThatCode(code).isExactlyInstanceOf(InvalidInputException.class).hasMessage("Invalid email address!");
    }

    /**
     * test if exception is thrown on invalid input
     */
    @Test
    void createSystemUserPasswordInvalidTest() {
        int id = 1;
        String firstName = "Svetoslav";
        String lastName = "Stoyanov";
        String email = "valid@abv.bg";
        String password = "123";
        String address = "franciscanenstraat 10";
        String role = "Customer";
        //Check if it is not null rather than .class

        ThrowableAssert.ThrowingCallable code = () -> {
            this.systemUserManager.createSystemUser(id, firstName, lastName, email, password, address, role);
        };

        assertThatCode(code).isExactlyInstanceOf(InvalidInputException.class).hasMessage("Invalid password!");
    }

    /**
     * test if exception is thrown on invalid input
     */
    @Test
    void createSystemUserAddressInvalidTest() {
        int id = 1;
        String firstName = "Svetoslav";
        String lastName = "Stoyanov";
        String email = "valid@abv.bg";
        String password = "1ASD!x_asd";
        String address = "123";
        String role = "Customer";
        //Check if it is not null rather than .class

        ThrowableAssert.ThrowingCallable code = () -> {
            this.systemUserManager.createSystemUser(id, firstName, lastName, email, password, address, role);
        };

        assertThatCode(code).isExactlyInstanceOf(InvalidInputException.class).hasMessage("Invalid address!");
    }

    /**
     * test if exception is thrown on invalid input
     */
    @Test
    void createSystemUserRoleInvalidTest() {
        int id = 1;
        String firstName = "Svetoslav";
        String lastName = "Stoyanov";
        String email = "valid@abv.bg";
        String password = "1ASD!x_asd";
        String address = "franciscanenstraat 10";
        String role = "InvalidRole";
        //Check if it is not null rather than .class

        ThrowableAssert.ThrowingCallable code = () -> {
            this.systemUserManager.createSystemUser(id, firstName, lastName, email, password, address, role);
        };

        assertThatCode(code).isExactlyInstanceOf(InvalidInputException.class).hasMessage("Invalid role!");
    }

    /**
     * Test is DEPENDENT and specific for the current Database
     *
     * @throws ClassNotFoundException
     * @throws SystemUserStorageException
     * @throws AccountNotFoundException
     */
    @Test
    void getByEmailDataBaseTest() throws ClassNotFoundException, SystemUserStorageException, AccountNotFoundException {
        //TODO: DB Should not be empty! - Testing like this because insert and then getByEmail causes problems with the Id (because it is autoincrement in the code)
        //Get very first system user by Id
        SystemUser expected = this.systemUserManager.getById(1);
        //Use the existing systemUser to test if getByEmail works
        SystemUser actual = this.systemUserManager.getByEmail(expected.getEmail());
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }


    /**
     * Test is DEPENDENT and specific for the current Database
     */
    @Test
    void loginDbTest() throws ClassNotFoundException, SystemUserStorageException, AccountNotFoundException {
        //Need to exist in the DB
        String loginEmail = "asd@abv.bg";
        String loginPassword = "n!k@sn1Kos";
        //check if the login is properly comparing input
        SystemUser expected = this.systemUserManager.getByEmail(loginEmail);
        SystemUser actual = this.systemUserManager.login(loginEmail, loginPassword);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    /**
     * Test is DEPENDENT and specific for the current Database
     */
    @Test
    void addDatabaseTest() throws ClassNotFoundException, SystemUserStorageException, AccountNotFoundException, SQLException {
        int id = 0;
        String firstName = "Svetoslav";
        String lastName = "Stoyanov";
        String email = generateEmail();
        String password = "1ASD!x_asd";
        String address = "franciscanenstraat 10";
        String role = "Customer";
        //Create user
        SystemUser expected = this.systemUserManager.createSystemUser(id, firstName, lastName, email, password, address, role);
        //add to DB
        this.systemUserManager.add(expected);
        //get by Email
        SystemUser actual = this.systemUserManager.getByEmail(email);
        //check if properly added and getByEmail, comparing by Email because Id is autoincrement and wont work.
        assertThat(actual.getEmail()).isEqualTo(expected.getEmail());
    }

    /**
     * Test if login is called and is returning correct user
     * Mock
     */
    @Test
    public void loginTest() throws ClassNotFoundException, SystemUserStorageException, AccountNotFoundException {
        SystemUser expected = new SystemUser(1, "test", "test", "asd@abv.bg", "n!k@sn1Kos", "franciscanenstraat 10", "Customer");

        //Train the mock
        when(this.systemUserStorageServiceMock.retrieve("asd@abv.bg", "n!k@sn1Kos")).thenReturn(expected);

        //Assign mocked service to SUT
        this.systemUserManager.setSystemUserStorageService(this.systemUserStorageServiceMock);

        assertThat(this.systemUserManager.login("asd@abv.bg", "n!k@sn1Kos")).isEqualTo(expected);
        //verify that retrieve is called at least once
        verify(this.systemUserStorageServiceMock).retrieve("asd@abv.bg", "n!k@sn1Kos");
    }

    /**
     * Test if getByEmail is called and is returning correct user
     * Mock
     */
    @Test
    void getByEmailNoDBTest() throws SystemUserStorageException, AccountNotFoundException, ClassNotFoundException {
        SystemUser expected = new SystemUser(1, "test", "test", "uniqueMail@abv.bg", "n!k@sn1Kos", "franciscanenstraat 10", "Customer");

        //Train the mock
        when(this.systemUserStorageServiceMock.getByEmail("uniqueMail@abv.bg")).thenReturn(expected);

        //Assign mocked service to SUT
        this.systemUserManager.setSystemUserStorageService(this.systemUserStorageServiceMock);

        assertThat(this.systemUserManager.getByEmail("uniqueMail@abv.bg")).isEqualTo(expected);
        //verify that retrieve is called at least once
        verify(this.systemUserStorageServiceMock).getByEmail("uniqueMail@abv.bg");
    }


    @Test
    public void generateSalesOfficerIdTest() {
        int expectedLowest = this.systemUserStorageService.getLowestSalesOfficerId();
        int expectedBiggest = this.systemUserStorageService.getBiggestSalesOfficerId();
        int actual = this.systemUserManager.generateSalesOfficerId();
        assertThat(actual).isBetween(expectedLowest, expectedBiggest);
    }
}
