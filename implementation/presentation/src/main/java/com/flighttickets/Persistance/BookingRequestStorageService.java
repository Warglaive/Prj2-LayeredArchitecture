package com.flighttickets.Persistance;

import com.flighttickets.Entities.BookingRequestManager;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

public class BookingRequestStorageService {
    private final PGDAOFactory daoFactory;

    public BookingRequestStorageService(PGDAOFactory daoFactory) {
        this.daoFactory=daoFactory;
    }
    //TODO: Instantiate DAO
}
