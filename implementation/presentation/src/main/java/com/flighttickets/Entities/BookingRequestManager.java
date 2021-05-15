package com.flighttickets.Entities;

import com.flighttickets.Persistance.BookingRequestStorageService;

import java.time.LocalDate;

public interface BookingRequestManager {
    BookingRequest createBookingRequest(int requestId, int customerId, int salesOfficerId, String departureDestination, String arrivalDestination, LocalDate departureDate, LocalDate returnDate, int passengersAmount, String status) ;

    void setBookingRequestStorageService(BookingRequestStorageService bookingRequestStorageService);
}
