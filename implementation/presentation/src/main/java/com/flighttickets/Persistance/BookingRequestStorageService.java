package com.flighttickets.Persistance;

import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.BookingRequestMapper;
import com.flighttickets.Entities.Route;
import com.flighttickets.Entities.SystemUser;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.util.List;

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


    public List<BookingRequest> getPendingRequests() {
        List<BookingRequest> requestsList = this.bookingRequestDAO.anyQuery("SELECT * FROM " +this.tableName+ " WHERE status = 'Pending'");
        //TODO Write exception/error for no lists returned - JL
        return requestsList;
    }

    public void declineRequest(BookingRequest toBeDeclined){
        toBeDeclined.setStatus("Declined");
        this.bookingRequestDAO.update(toBeDeclined);
        System.out.println("Booking request" + toBeDeclined.getId() + "declined!");
        //TODO Write message to user properly - JL
    }
}
