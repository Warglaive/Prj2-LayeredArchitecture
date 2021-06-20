package com.flighttickets.Persistance;

import com.flighttickets.BusinessLogic.Exceptions.SystemUserStorageException;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserMapper;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public class SystemUserStorageService {
    private final PGDAOFactory pgdaoFactory;
    private final PGDAO<Integer, SystemUser> systemUserDAO;
    private final String tableName = "systemUser";


    public SystemUserStorageService(PGDAOFactory pgdaoFactory) {
        this.pgdaoFactory = pgdaoFactory;
        // Use the provided data source

        // Register mappers for the classes in this app
        this.pgdaoFactory.registerMapper(SystemUser.class, new SystemUserMapper());
        // get a dao (no transactions yet).
        this.systemUserDAO = this.pgdaoFactory.createDao(SystemUser.class);
    }

    public int getCount() {
        return this.systemUserDAO.size();
    }

    /**
     * Save a SystemUser object to the database using a DataAccessObject
     *
     * @param SystemUser
     */
    public void insert(SystemUser SystemUser) {
        this.systemUserDAO.save(SystemUser);
    }

    public SystemUser getByEmail(String email) throws AccountNotFoundException, SystemUserStorageException {
        List<SystemUser> customerList = systemUserDAO.anyQuery("SELECT * FROM " + this.tableName + " WHERE email= '" + email + "' ");
        if (customerList.isEmpty()) {
            throw new AccountNotFoundException("no such " + email);
        } else if (customerList.size() > 1) {
            throw new SystemUserStorageException("Duplicate emails exist in the Database!");
        } else return customerList.get(0);
    }

    public SystemUser retrieve(String email, String password) throws SystemUserStorageException, AccountNotFoundException {
        List<SystemUser> customerList = systemUserDAO.anyQuery("SELECT * FROM " + this.tableName + " WHERE email= '" + email + "' and password= '" + password + "' ");
        //Test if an actual SystemUser is found
        //System.out.println("The customers found is = " + customerList.size());
        //If statement looks if one SystemUser is found. More customers by the same email or 0 customers will result in a fail
        if (customerList.size() == 1) {
            return customerList.get(0);
        } else if(customerList.size() > 1){
            throw new SystemUserStorageException("There is multiple users found by that combination");
        } else {
            throw new AccountNotFoundException("No such user found with that combination");
        }
    }

    /**
     * @return all registered users as a List
     */
    public List<SystemUser> getAll() {
        return this.systemUserDAO.getAll();
    }

    public List<SystemUser> getAllByRole(String role) {
        String query = "select * from systemuser \n" +
                "where role =" + role;
        return this.systemUserDAO.anyQuery(query);
    }


    //TODO: Make method to retrieve lowest Id number and biggest Id number for salesOfficer
    public int getLowestSalesOfficerId() {
        //take first lowest ID for systemUser with Role "SalesOfficer" From the DB.
        //create query
        String query = "select * from systemuser \n" +
                "where role = 'SalesOfficer'\n" +
                "order by systemuserid asc\n" +
                "limit 1\n";
        List<SystemUser> result = this.systemUserDAO.anyQuery(query);
        return result.get(0).getId();
    }

    public int getBiggestSalesOfficerId() {
        //take first lowest ID for systemUser with Role "SalesOfficer" From the DB.
        //create query
        String query = "select * from systemuser \n" +
                "where role = 'SalesOfficer'\n" +
                "order by systemuserid desc\n" +
                "limit 1\n";
        List<SystemUser> result = this.systemUserDAO.anyQuery(query);

        return result.get(0).getId();
    }

    public SystemUser getById(int id) {
        List<SystemUser> customerList = systemUserDAO.anyQuery("SELECT * FROM " + this.tableName + " WHERE systemuserid= '" + id + "' ");
        return customerList.get(0);
    }
}
