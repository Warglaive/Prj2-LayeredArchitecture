package com.flighttickets.Entities;

import com.flighttickets.BusinessLogic.Exceptions.DateOutOfBoundException;
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
     * getter for BookingRequestStorageService
     *
     * @return BookingRequestStorageService
     */
    public BookingRequestStorageService getBookingRequestStorageService();

    /**
     * @param bookingRequest add to DB
     * @throws SQLException
     * @throws ClassNotFoundException
     * @return
     */
    BookingRequest add(BookingRequest bookingRequest) throws SQLException, ClassNotFoundException, DateOutOfBoundException;

    /**
     * @param customerId - search by
     * @return List of booking requests for current logged in customer
     */
    public List<BookingRequest> getAllByCustomerId(int customerId);


    /**
     * @return All requests pending to be handled
     */
    List<BookingRequest> getPendingRequests();

    /**
     * @param toBeDeclined
     */
    BookingRequest declineRequest(BookingRequest toBeDeclined);

    BookingRequest acceptRequest(BookingRequest toBeAccepted);
}
