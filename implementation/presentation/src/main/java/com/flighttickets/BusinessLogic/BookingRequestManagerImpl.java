package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Persistance.BookingRequestStorageService;

public class BookingRequestManagerImpl implements BookingRequestManager {


    private BookingRequestStorageService bookingRequestStorageService;


    @Override
    public BookingRequest createBookingRequest() {
        //:TODO: Implement
        return null;
    }

    public void setBookingRequestStorageService(BookingRequestStorageService bookingRequestStorageService) {
        this.bookingRequestStorageService = bookingRequestStorageService;

    }

    public BookingRequestStorageService getBookingRequestStorageService() {
        return bookingRequestStorageService;
    }
}
