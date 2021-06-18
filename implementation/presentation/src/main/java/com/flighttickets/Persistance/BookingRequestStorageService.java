package com.flighttickets.Persistance;

import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.BookingRequestMapper;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is used for executing CUSTOM or DAO SQL statements
 */
public class BookingRequestStorageService {
    private final PGDAOFactory pgdaoFactory;
    private final PGDAO<Integer, BookingRequest> bookingRequestDAO;
    /**
     * tableName reduce SQL code
     */
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

    /**
     * @return all booking requests corresponding to the customer id
     */
    public List<BookingRequest> getAllByCustomerId(int customerId) {
        //TODO: Can not cast to LIST
        return this.bookingRequestDAO.getAll().stream().filter(x -> x.getCustomerId() == customerId).collect(Collectors.toList());
    }

    public List<BookingRequest> getPendingRequests() {
        List<BookingRequest> requestsList = this.bookingRequestDAO.anyQuery("SELECT * FROM " +this.tableName+ " WHERE status = 'Pending'");
        //TODO Write exception/error for no lists returned - JL
        return requestsList;
    }

    public BookingRequest updateRequest(BookingRequest toBeUpdated){
        this.bookingRequestDAO.update(toBeUpdated);
        return toBeUpdated;
    }

}
