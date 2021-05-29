package com.flighttickets.BusinessLogic;

import com.flighttickets.BusinessLogic.Exceptions.InvalidInputException;
import com.flighttickets.BusinessLogic.Exceptions.SystemUserStorageException;
import com.flighttickets.Entities.RegisterInputValidator;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import com.flighttickets.Persistance.SystemUserStorageService;

import javax.security.auth.login.AccountNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

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
        //TODO: Validate each property of SystemUser and throw CUSTOM exception if something is wrong.
        //TODO: Make a array of boolean and throw exception for each isValid == false

        boolean isFirstNameValid = this.inputValidator.isNameValid(firstName);
        boolean isLastNameValid = this.inputValidator.isNameValid(lastName);
        boolean isEmailValid = this.inputValidator.isEmailValid(email);
        boolean isPasswordValid = this.inputValidator.isPasswordValid(password);
        boolean isAddressValid = this.inputValidator.isAddressValid(address);
        boolean isRoleValid = this.inputValidator.isRoleValid(role);
        boolean isAnyInvalid = false;
        //Add to string exception msg for each of the invalid input arguments
        String exceptionMessage = "";
        if (!isFirstNameValid) {
            exceptionMessage += "Invalid first name!";
            isAnyInvalid = true;
        }

        if (!isLastNameValid) {
            exceptionMessage = "Invalid last name!";
            isAnyInvalid = true;
        }

        if (!isEmailValid) {
            exceptionMessage = "Invalid email address!";
            isAnyInvalid = true;
        }

        if (!isPasswordValid) {
            exceptionMessage = "Invalid password!";
            isAnyInvalid = true;
        }

        if (!isAddressValid) {
            exceptionMessage = "Invalid address!";
            isAnyInvalid = true;
        }

        if (!isRoleValid) {
            exceptionMessage = "Invalid role!";
            isAnyInvalid = true;
        }
        if (isAnyInvalid) {
            throw new InvalidInputException(exceptionMessage);
        }
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
    public SystemUser login(String email, String password) throws ClassNotFoundException {
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
    /**
     * get users with role "SalesOfficer"
     */
}
