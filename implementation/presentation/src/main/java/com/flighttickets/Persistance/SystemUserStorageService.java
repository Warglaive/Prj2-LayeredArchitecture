package com.flighttickets.Persistance;


import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserMapper;
import com.flighttickets.PGDataSource;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.util.List;

public class SystemUserStorageService {

    private final PGDAO<Integer, SystemUser> systemUserDAO;
    private final String tableName = "systemUser";


    public SystemUserStorageService() {
        // Use the provided data source
        PGDAOFactory pdaof = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        pdaof.registerMapper(SystemUser.class, new SystemUserMapper());
        // get a dao (no transactions yet).
        this.systemUserDAO = pdaof.createDao(SystemUser.class);
    }

    /**
     * Save a SystemUser object to the database using a DataAccessObject
     *
     * @param SystemUser
     */
    public void insert(SystemUser SystemUser) {
        this.systemUserDAO.save(SystemUser);
    }

    public SystemUser retrieve(String email, String password) {
        //Try to get an SystemUser by its ID
        //SystemUser c = customerDAO.get(1).get();
        //TODO This works as soon as database name for customer_id is changed to customerid -JL
        List<SystemUser> customerList = systemUserDAO.anyQuery("SELECT * FROM " + this.tableName + " WHERE email= '" + email + "' and password= '" + password + "' ");
        //Test if an actual SystemUser is found
        //System.out.println("The customers found is = " + customerList.size());
        //If statement looks if one SystemUser is found. More customers by the same email or 0 customers will result in a fail
        if (customerList.size() == 1) {
            return customerList.get(0);
        } else {
            System.out.println("No SystemUser found by that Email/Pass");
            //Implement error for user trying to login
            return null;
        }
    }

    public List<SystemUser> getAll() {
        return this.systemUserDAO.getAll();
    }
}