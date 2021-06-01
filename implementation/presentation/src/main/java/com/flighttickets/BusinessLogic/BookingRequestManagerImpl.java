package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.BookingRequestManager;
import com.flighttickets.Persistance.BookingRequestStorageService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * this class is used for Business logic and NO Sql is written here.
 */
public class BookingRequestManagerImpl implements BookingRequestManager {


    private BookingRequestStorageService bookingRequestStorageService;


    @Override
    public BookingRequest createBookingRequest(int requestId, int customerId, Integer salesOfficerId, String departureDestination, String arrivalDestination, LocalDate departureDate, LocalDate returnDate, int passengersAmount, String status) {
        return new BookingRequest(requestId, customerId, salesOfficerId, departureDestination, arrivalDestination, departureDate, returnDate, passengersAmount, status);
    }

    @Override
    public void setBookingRequestStorageService(BookingRequestStorageService bookingRequestStorageService) {
        this.bookingRequestStorageService = bookingRequestStorageService;

    }

    @Override
    public void add(BookingRequest bookingRequest) throws SQLException, ClassNotFoundException {
        this.bookingRequestStorageService.insert(bookingRequest);
    }

    @Override
    public List<BookingRequest> getAllByCustomerId(int customerId) {
        return this.bookingRequestStorageService.getAllByCustomerId(customerId);
    }

    @Override
    public List<BookingRequest> getPendingRequests() {
        return this.bookingRequestStorageService.getPendingRequests();
    }

    @Override
    public void declineRequest(BookingRequest toBeDeclined) {
        this.bookingRequestStorageService.declineRequest(toBeDeclined);
    }

    @Override
    public BookingRequestStorageService getBookingRequestStorageService() {
        return bookingRequestStorageService;
    }
}
