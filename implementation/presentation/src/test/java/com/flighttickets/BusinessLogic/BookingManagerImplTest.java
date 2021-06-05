package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.BookingManager;
import com.flighttickets.Entities.BookingRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BookingManagerImplTest {

    BookingManager bookingManager;
    BookingRequest toBeFinalized;


    @BeforeEach
    void setUp() {
        //arguments to create BookingRequest with test values
        int bookingRequestId = 1;
        int customerId = 1;
        int salesOfficerId = 1;
        String departureDestination = "Test";
        String arrivalDestination = "Test";
        LocalDate departureDate = LocalDate.now();
        java.time.LocalDate returnDate = LocalDate.now().plusDays(1);
        int passengersAmount = 1;
        String status = "Pending";
        //
        this.toBeFinalized = new BookingRequest(bookingRequestId, customerId, salesOfficerId, departureDestination, arrivalDestination, departureDate, returnDate, passengersAmount, status);
        BookingManager bookingManager = new BookingManagerImpl(this.toBeFinalized);
    }


    @Test
    void calculatePriceTest() {

    }
}
