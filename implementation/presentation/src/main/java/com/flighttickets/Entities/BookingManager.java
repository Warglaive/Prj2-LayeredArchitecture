package com.flighttickets.Entities;

import com.flighttickets.Persistance.BookingStorageService;

import java.sql.SQLException;
import java.time.LocalDate;

public interface BookingManager {
    Booking createBooking(int bookingId, int salesOfficerId, int customerId, LocalDate bookingDate);

    void setBookingStorageService(BookingStorageService bookingStorageService);

    double calculatePrice();
    //Todo add descriptions
  
    int add(Booking booking);
    //Todo add descriptions -JL

}
