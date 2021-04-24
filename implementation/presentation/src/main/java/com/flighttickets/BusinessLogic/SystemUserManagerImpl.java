package com.flighttickets.BusinessLogic;

import com.flighttickets.BusinessLogic.Exceptions.InvalidInputException;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserManager;
import com.flighttickets.Persistance.SystemUserStorageService;
import javafx.fxml.FXML;

import java.sql.SQLException;

public class SystemUserManagerImpl implements SystemUserManager {

    //TODO: Add validator class to validate user input
    RegisterInputValidator inputValidator;
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

    @Override
    public SystemUser createSystemUser(int id, String firstName, String lastName, String email, String password, String address, String role) {
        //TODO: Validate each property of SystemUser and throw CUSTOM exception if something is wrong.
        //TODO: Make a array of boolean and throw exception for each isValid == false

        boolean isFirstNameValid = this.inputValidator.isNameValid(firstName);
        boolean isLastNameValid = this.inputValidator.isNameValid(lastName);
        boolean isEmailValid = this.inputValidator.isEmailValid(email);
        boolean isPasswordValid = this.inputValidator.isPasswordValid(password);
        boolean isAddressValid = this.inputValidator.isAddressValid(address);
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
            exceptionMessage = "Invalid address";
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

    public SystemUser getByEmail(String email) throws ClassNotFoundException {
        //TODO: Implement/See if its still needed - JL
        return null;
    }

    @FXML
    public SystemUser login(String email, String password) throws ClassNotFoundException {
        //Retrieves system user from database based on email, password -JL
        return this.systemUserStorageService.retrieve(email, password);
    }
}