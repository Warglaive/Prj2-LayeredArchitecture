package com.flighttickets.Entities;

import com.flighttickets.Persistance.BookingStorageService;

import java.sql.SQLException;
import java.time.LocalDate;

public interface BookingManager {
    Booking createBooking(int bookingId, int salesOfficerId, int customerId, LocalDate bookingDate);

    void setBookingStorageService(BookingStorageService bookingStorageService);

    int add(Booking booking) throws SQLException, ClassNotFoundException;
    //Todo add descriptions -JL


}
