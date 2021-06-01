package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Booking;
import com.flighttickets.Entities.BookingManager;
import com.flighttickets.Persistance.BookingStorageService;

import java.sql.SQLException;
import java.time.LocalDate;

public class BookingManagerImpl implements BookingManager {
    private BookingStorageService bookingStorageService;

    @Override
    public Booking createBooking(int bookingId, int salesOfficerId, int customerId, LocalDate bookingDate) {
        return new Booking(bookingId,customerId,salesOfficerId,bookingDate);
    }

    @Override
    public void setBookingStorageService(BookingStorageService bookingStorageService) {
        this.bookingStorageService = bookingStorageService;
    }

    @Override
    public int add(Booking booking) throws SQLException, ClassNotFoundException {
        return this.bookingStorageService.insert(booking);
    }
}
