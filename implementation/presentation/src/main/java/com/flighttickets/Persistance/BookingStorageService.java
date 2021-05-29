package com.flighttickets.Persistance;

import com.flighttickets.Entities.Booking;
import com.flighttickets.Entities.BookingMapper;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

public class BookingStorageService {
    private final PGDAOFactory pgdaoFactory;
    private final PGDAO<Integer, Booking> bookingDAO;
    private final String tableName = "booking";

    public BookingStorageService(PGDAOFactory pgdaoFactory){
        this.pgdaoFactory = pgdaoFactory;
        this.pgdaoFactory.registerMapper(Booking.class, new BookingMapper());
        this.bookingDAO = this.pgdaoFactory.createDao(Booking.class);
    }

    public void insert(Booking booking) {this.bookingDAO.save(booking);}
}
