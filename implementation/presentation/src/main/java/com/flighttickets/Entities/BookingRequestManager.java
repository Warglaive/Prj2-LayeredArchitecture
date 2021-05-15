package com.flighttickets.Entities;

import com.flighttickets.Persistance.BookingRequestStorageService;

import java.time.LocalDate;

public interface BookingRequestManager {
    BookingRequest createBookingRequest(int id, LocalDate departureDate, LocalDate returnDate, String departureDestination, String destination, int customerId, int passengersAmount, boolean status) ;

    void setBookingRequestStorageService(BookingRequestStorageService bookingRequestStorageService);
}
