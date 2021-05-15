package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Persistance.BookingRequestStorageService;
import com.flighttickets.Persistance.SystemUserStorageService;

import java.time.LocalDate;

public class BookingRequestManagerImpl implements BookingRequestManager {


    private BookingRequestStorageService bookingRequestStorageService;


    @Override
    public BookingRequest createBookingRequest(int requestId, int customerId, int salesOfficerId, String departureDestination, String arrivalDestination, LocalDate departureDate, LocalDate returnDate, int passengersAmount, String status) {
        return null;
    }

    public void setBookingRequestStorageService(BookingRequestStorageService bookingRequestStorageService) {
        this.bookingRequestStorageService = bookingRequestStorageService;

    }

    public BookingRequestStorageService getBookingRequestStorageService() {
        return bookingRequestStorageService;
    }
}
