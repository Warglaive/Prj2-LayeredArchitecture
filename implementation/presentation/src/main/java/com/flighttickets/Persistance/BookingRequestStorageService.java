package com.flighttickets.Persistance;

import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.BookingRequestMapper;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

public class BookingRequestStorageService {
    private final PGDAOFactory pgdaoFactory;
    private final PGDAO<Integer, BookingRequest> bookingRequestDAO;
    private final String tableName = "bookingRequest";

    public BookingRequestStorageService(PGDAOFactory pgdaoFactory) {
        this.pgdaoFactory = pgdaoFactory;
        // Use the provided data source

        // Register mappers for the classes in this app
        this.pgdaoFactory.registerMapper(BookingRequest.class, new BookingRequestMapper());
        // get a dao (no transactions yet).
        this.bookingRequestDAO = this.pgdaoFactory.createDao(BookingRequest.class);

    }

    /**
     * Save a BookingRequest object to the database using a DataAccessObject
     *
     * @param bookingRequest
     */
    public void insert(BookingRequest bookingRequest) {
        this.bookingRequestDAO.save(bookingRequest);
    }


}
