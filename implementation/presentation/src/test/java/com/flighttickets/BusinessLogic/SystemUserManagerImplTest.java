package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import com.flighttickets.Persistance.SystemUserStorageService;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

public class SystemUserManagerImplTest {

    private SystemUserStorageService SystemUserStorageService;
    private SystemUserManager SystemUserManager;


    @BeforeEach
    void setUp() {
        this.SystemUserManager = new SystemUserManagerImpl();
        this.SystemUserStorageService = new SystemUserStorageService();
        this.SystemUserManager.setSystemUserStorageService(this.SystemUserStorageService);
    }

    /**
     * test if setSystemUserStorageService sets StorageService properly with the help of getSystemUserStorageService helper method.
     */


    @Test
    void setSystemUserStorageService() {
        assertThat(this.SystemUserManager.getSystemUserStorageService()).isExactlyInstanceOf(SystemUserStorageService.class);
    }

    /**
     * test if SystemUser object is properly created
     */


    @Test
    void createSystemUserTest() {
        String firstName = "1";
        String lastName = "1";
        String email = "1";
        String password = "1";
        String address = "1";
        int level = 2;
        //Check if it is not null rather than .class
        assertThat(this.SystemUserManager.createSystemUser(firstName, lastName, email, password, address, level))
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
        SystemUser actual = this.SystemUserManager.createSystemUser(firstName, lastName, email, password, address, level);
        //add SystemUser to Storage
        this.SystemUserManager.add(actual);
        //get SystemUser
        String emailExpected = actual.getEmail();
        SystemUser expected = this.SystemUserManager.getByEmail(emailExpected);
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
        SystemUser( actual = this.SystemUserManager.createSystemUser(firstName, lastName, email, password, address, level);
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
    //TODO: add test for login method
}
