package com.flighttickets.Entities;

import com.flighttickets.Persistance.BookingRequestStorageService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface BookingRequestManager {
    /**
     * create booking request entity from arguments
     *
     * @param requestId
     * @param customerId
     * @param salesOfficerId
     * @param departureDestination
     * @param arrivalDestination
     * @param departureDate
     * @param returnDate
     * @param passengersAmount
     * @param status
     * @return
     */
    BookingRequest createBookingRequest(int requestId, int customerId, Integer salesOfficerId, String departureDestination, String arrivalDestination, LocalDate departureDate, LocalDate returnDate, int passengersAmount, String status);

    /**
     * setter for
     *
     * @param bookingRequestStorageService
     */
    void setBookingRequestStorageService(BookingRequestStorageService bookingRequestStorageService);

    /**
     * @param bookingRequest
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    void add(BookingRequest bookingRequest) throws SQLException, ClassNotFoundException;


    /**
     * @return All requests pending to be handled
     */
    List<BookingRequest> getPendingRequests();

    void declineRequest(int requestId);

}
