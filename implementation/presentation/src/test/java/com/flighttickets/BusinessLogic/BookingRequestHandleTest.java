package com.flighttickets.BusinessLogic;
import com.flighttickets.Entities.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


public class BookingRequestHandleTest {

    BookingRequest testRequest = new BookingRequest(1,2,3,
            "Schiphol", "Fraport",
            LocalDate.of(2021,9,24), LocalDate.of(2021, 9,27),
            1, "Pending");

    Booking testBooking = new Booking(1,2,3, LocalDate.of(2021,9,24));

    @BeforeEach
    void setUp(){
    }

    @Test
    public void BookingTestConstructor(){
        assertThat(testBooking.getBookingId()).isEqualTo(1);
        assertThat(testBooking.getCustomerId()).isEqualTo(2);
        assertThat(testBooking.getSalesOfficerId()).isEqualTo(3);
        assertThat(testBooking.getBookingDate()).isEqualTo(LocalDate.of(2021,9,24));
        assertThat(testBooking).isExactlyInstanceOf(Booking.class);
    }

    @Test
    public void BookingRequestTestConstructor(){
        assertThat(testRequest.getBookingRequestId()).isEqualTo(1);
        assertThat(testRequest.getCustomerId()).isEqualTo(2);
        assertThat(testRequest.getSalesOfficerId()).isEqualTo(3);
        assertThat(testRequest.getDepartureDestination()).isEqualTo("Schiphol");
        assertThat(testRequest.getArrivalDestination()).isEqualTo("Fraport");
        assertThat(testRequest.getDepartureDate()).isEqualTo(LocalDate.of(2021,9,24));
        assertThat(testRequest.getReturnDate()).isEqualTo(LocalDate.of(2021,9,27));
        assertThat(testRequest.getPassengersAmount()).isEqualTo(1);
        assertThat(testRequest.getStatus()).isEqualTo("Pending");
        assertThat(testRequest).isExactlyInstanceOf(BookingRequest.class);
    }

}
