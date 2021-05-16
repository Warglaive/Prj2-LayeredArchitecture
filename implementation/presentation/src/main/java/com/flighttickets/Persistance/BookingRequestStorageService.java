package com.flighttickets.Persistance;

import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.BookingRequestMapper;
import com.flighttickets.Entities.SystemUser;
import com.flighttickets.Entities.SystemUserMapper;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

public class BookingRequestStorageService {
    private final PGDAOFactory pgdaoFactory;
    private final PGDAO<Integer, SystemUser> systemUserDAO;
    private final String tableName = "bookingrequest";

    public BookingRequestStorageService(PGDAOFactory pgdaoFactory) {
        this.pgdaoFactory = pgdaoFactory;
        // Use the provided data source

        // Register mappers for the classes in this app
        this.pgdaoFactory.registerMapper(SystemUser.class, new BookingRequestMapper());
        // get a dao (no transactions yet).
        this.systemUserDAO = this.pgdaoFactory.createDao(SystemUser.class);

    }

    public void insert(BookingRequest bookingRequest) {

    }
    //TODO: Instantiate DAO
}
