package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Persistance.BookingRequestStorageService;

import java.sql.SQLException;
import java.time.LocalDate;

public class BookingRequestManagerImpl implements BookingRequestManager {


    private BookingRequestStorageService bookingRequestStorageService;


    @Override
    public BookingRequest createBookingRequest(int requestId, int customerId, Integer salesOfficerId, String departureDestination, String arrivalDestination, LocalDate departureDate, LocalDate returnDate, int passengersAmount, String status) {
        return new BookingRequest(requestId, customerId, salesOfficerId, departureDestination, arrivalDestination, departureDate, returnDate, passengersAmount, status);
    }

    public void setBookingRequestStorageService(BookingRequestStorageService bookingRequestStorageService) {
        this.bookingRequestStorageService = bookingRequestStorageService;

    }

    @Override
    public void add(BookingRequest bookingRequest) throws SQLException, ClassNotFoundException {
        this.bookingRequestStorageService.insert(bookingRequest);
    }

    public BookingRequestStorageService getBookingRequestStorageService() {
        return bookingRequestStorageService;
    }
}
