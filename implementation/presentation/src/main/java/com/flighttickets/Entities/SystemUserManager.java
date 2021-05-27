package com.flighttickets.Entities;

import com.flighttickets.Persistance.SystemUserStorageService;

import java.sql.SQLException;

public interface SystemUserManager {
    /**
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param address
     * @param role
     * @return SystemUser
     */
    SystemUser createSystemUser(int id,String firstName, String lastName, String email, String password, String address, String role);

    /**
     * @param SystemUser
     * @return SystemUser
     */
    void add(SystemUser SystemUser) throws SQLException, ClassNotFoundException;

    /**
     * @param email
     * @return SystemUser
     */
    SystemUser getByEmail(String email) throws ClassNotFoundException;

    /**
     * setter for CustomerStorageService
     */
    void setSystemUserStorageService(SystemUserStorageService systemUserStorageService);

    SystemUserStorageService getSystemUserStorageService();

    SystemUser login(String email, String password) throws ClassNotFoundException;

    int generateSalesOfficerId();
}
