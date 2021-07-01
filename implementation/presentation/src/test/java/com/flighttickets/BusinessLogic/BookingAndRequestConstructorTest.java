package com.flighttickets.BusinessLogic;

import com.flighttickets.BusinessLogic.Exceptions.InvalidInputException;
import com.flighttickets.Entities.*;
import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;




public class BookingAndRequestConstructorTest {

    BookingRequest testRequest = new BookingRequest(1,2,3,
            "Schiphol", "Fraport",
            LocalDate.of(2021,9,24), LocalDate.of(2021, 9,27),
            1, "Pending");

    Booking testBooking = new Booking(1,2,3, LocalDate.of(2021,9,24));

    Ticket testTicket = new Ticket(1,200,3,6,6,"ForSale");

    SystemUser testUser = new SystemUser(1,"Jasper", "Lamers", "jasper-l@live.nl","Southpark1!","Lindeboom 79 Mook", "SalesEmployee");

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

    @Test
    public void TicketTestConstructor(){
        assertThat(testTicket.getId()).isEqualTo(1);
        assertThat(testTicket.getPrice()).isEqualTo(200);
        assertThat(testTicket.getPassengerid()).isEqualTo(3);
        assertThat(testTicket.getBookingid()).isEqualTo(6);
        assertThat(testTicket.getFlightid()).isEqualTo(6);
        assertThat(testTicket.getStatus()).isEqualTo("ForSale");
        assertThat(testTicket).isExactlyInstanceOf(Ticket.class);
    }

    @Test
    public void SystemUserTestConstructor(){
        assertThat(testUser.getId()).isEqualTo(1);
        assertThat(testUser.getFirstName()).isEqualTo("Jasper");
        assertThat(testUser.getLastName()).isEqualTo("Lamers");
        assertThat(testUser.getEmail()).isEqualTo("jasper-l@live.nl");
        assertThat(testUser.getPassword()).isEqualTo("Southpark1!");
        assertThat(testUser.getAddress()).isEqualTo("Lindeboom 79 Mook");
        assertThat(testUser.getRole()).isEqualTo("SalesEmployee");
        assertThat(testUser).isExactlyInstanceOf(SystemUser.class);
    }

    @Test
    //Small Test for Svetoslavs Validator
    void createSystemUserRoleInvalidTest() {
        int id = 1;
        String firstName = "Jasper";
        String lastName = "Lamers";
        String email = "sales@employee.nl";
        String password = "Southpark1!";
        String address = "Lindeboom 79 Mook";
        String role = "BadRole";


        SystemUserManagerImpl systemUserManager = new SystemUserManagerImpl();

        ThrowableAssert.ThrowingCallable code = () -> {
           systemUserManager.createSystemUser(id, firstName, lastName, email, password, address, role);
        };

        assertThatCode(code).isExactlyInstanceOf(InvalidInputException.class).hasMessage("Invalid role!");
    }

}
