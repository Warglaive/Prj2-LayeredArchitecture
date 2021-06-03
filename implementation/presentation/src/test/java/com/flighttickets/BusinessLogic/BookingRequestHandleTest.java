package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.BookingRequest;
import com.flighttickets.Entities.Booking;
import com.flighttickets.Entities.BookingRequestManager;
import org.junit.Assert.*;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.time.LocalDate;
import java.util.List;

public class BookingRequestHandleTest {
    //BookingRequestManager test = BookingRequestManagerImpl();

    @Test
    public void BookingTestConstructor(){
        Booking test = new Booking(1,2,3, LocalDate.of(2021,9,24));
        assertThat(test.getBookingId()).isEqualTo(1);
        assertThat(test.getCustomerId()).isEqualTo(2);
        assertThat(test.getSalesOfficerId()).isEqualTo(3);
        assertThat(test.getBookingDate()).isEqualTo(LocalDate.of(2021,9,24));
    }

    @Test
    public void BookingRequestTestConstructor(){
        BookingRequest testRequest = new BookingRequest(1,2,3,
                "Schiphol", "Fraport",
                LocalDate.of(2021,9,24), LocalDate.of(2021, 9,27),
                1, "Pending");

        assertThat(testRequest.getBookingRequestId()).isEqualTo(1);
        assertThat(testRequest.getCustomerId()).isEqualTo(2);
        assertThat(testRequest.getSalesOfficerId()).isEqualTo(3);
        assertThat(testRequest.getDepartureDestination()).isEqualTo("Schiphol");
        assertThat(testRequest.getArrivalDestination()).isEqualTo("Fraport");
        assertThat(testRequest.getDepartureDate()).isEqualTo(LocalDate.of(2021,9,24));
        assertThat(testRequest.getReturnDate()).isEqualTo(LocalDate.of(2021,9,27));
        assertThat(testRequest.getPassengersAmount()).isEqualTo(1);
        assertThat(testRequest.getStatus()).isEqualTo("Pending");
    }

    @Test void ReceiveBookingRequestListTest(){
        //List<BookingRequest> testList = this.bookingRequestManager.getPendingRequests();
    }

    @Test
    public void BookingRequestHandleDeclineTest(){

    }

    @Test
    public void BookingRequestHandleAcceptTest(){

    }
}
