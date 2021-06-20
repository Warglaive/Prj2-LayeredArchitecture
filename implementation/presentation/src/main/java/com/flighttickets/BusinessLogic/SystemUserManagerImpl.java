package com.flighttickets.BusinessLogic;

import com.flighttickets.BusinessLogic.Exceptions.SystemUserStorageException;
import com.flighttickets.Entities.RegisterInputValidator;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import com.flighttickets.Persistance.SystemUserStorageService;

import javax.security.auth.login.AccountNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * this class is used for Business logic and NO Sql is written here.
 */
public class SystemUserManagerImpl implements SystemUserManager {

    //TODO: Add validator class to validate user input
    private RegisterInputValidator inputValidator;
    //TODO: Add HashPassword method
    private SystemUserStorageService systemUserStorageService;

    public void setSystemUserStorageService(SystemUserStorageService systemUserStorageService) {
        this.systemUserStorageService = systemUserStorageService;
        this.inputValidator = new RegisterInputValidatorImpl();
    }

    /**
     * Test helper method
     *
     * @return
     */
    public SystemUserStorageService getSystemUserStorageService() {
        return systemUserStorageService;
    }

    /**
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param address
     * @param role
     * @return SystemUser Used by REGISTER Method
     */
    @Override
    public SystemUser createSystemUser(int id, String firstName, String lastName, String email, String password, String address, String role) {
        return new SystemUser(id, firstName, lastName, email, password, address, role);
    }

    /**
     * pass SystemUser to StorageService to be added into the DB
     *
     * @param systemUser
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void add(SystemUser systemUser) throws SQLException, ClassNotFoundException {
        this.systemUserStorageService.insert(systemUser);
    }

    /**
     * @param email
     * @return SystemUser
     * @throws SystemUserStorageException
     * @throws AccountNotFoundException
     */
    public SystemUser getByEmail(String email) throws SystemUserStorageException, AccountNotFoundException {
        return this.systemUserStorageService.getByEmail(email);
    }

    /**
     * @param id
     * @return
     */
    public SystemUser getById(int id) {
        return this.systemUserStorageService.getById(id);
    }

    /**
     * @param email
     * @param password
     * @return
     * @throws ClassNotFoundException
     */
    public SystemUser login(String email, String password) throws ClassNotFoundException,SystemUserStorageException, AccountNotFoundException{
        //Retrieves system user from database based on email, password -JL
        return this.systemUserStorageService.retrieve(email, password);
    }

    /**
     * @return random generated salesOfficer id
     */
    public int generateSalesOfficerId() {
        int lowestSalesOfficerId = this.systemUserStorageService.getLowestSalesOfficerId();
        int biggestSalesOfficerId = this.systemUserStorageService.getBiggestSalesOfficerId();

        Random r = new Random();
        int low = lowestSalesOfficerId;
        int high = biggestSalesOfficerId;
        int result = r.nextInt(high - low) + low;
        return result;
    }

    /**
     * @return count of all registered users
     */
    public int getRegisteredUsersCount() {
        return this.systemUserStorageService.getCount();
    }

    /**
     * get users with role "SalesOfficer"
     */
    public List<SystemUser> getAllByRole(String role) {
        return this.systemUserStorageService.getAllByRole(role);
    }
}
