package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.*;
import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.BookingRequestStorageService;
import com.flighttickets.Persistance.BookingStorageService;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceImplementationProvider;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;
import org.junit.Assert.*;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.time.LocalDate;
import java.util.List;

public class BookingRequestHandleTest {
    private BusinessLogicAPI bookingbusinessLogicAPI;
    private PersistenceAPI bookingpersistenceAPI;
    private BusinessLogicAPI bookingRequestbusinessLogicAPI;
    private PersistenceAPI bookingRequestpersistenceAPI;
    private BookingStorageService bookingStorageService;
    private BookingRequestStorageService bookingRequestStorageService;
    private BookingRequestManager bookingRequestManager;
    private BookingManager bookingManager;

    BookingRequest testRequest = new BookingRequest(1,2,3,
            "Schiphol", "Fraport",
            LocalDate.of(2021,9,24), LocalDate.of(2021, 9,27),
            1, "Pending");

    @BeforeEach
    void setUp(){
        PGDAOFactory daoFactoryBooking = new PGDAOFactory(PGDataSource.DATA_SOURCE);
        PGDAOFactory daoFactoryBookingRequest = new PGDAOFactory(PGDataSource.DATA_SOURCE);
        // Register mappers for the classes in this app
        daoFactoryBooking.registerMapper(Booking.class, new BookingMapper());
        daoFactoryBookingRequest.registerMapper(BookingRequest.class, new BookingRequestMapper());

        //Gets&Sets Booking Persistance and Business for test also sets storage
//        this.bookingpersistenceAPI = PersistenceImplementationProvider.getImplementation(daoFactoryBooking);
//        this.bookingbusinessLogicAPI = BusinessLogicImplementationProvider.getImplementation(bookingpersistenceAPI);
//        this.bookingStorageService = this.bookingpersistenceAPI.getBookingStorageService();
//        this.bookingManager = this.bookingbusinessLogicAPI.getBookingManager();
//        this.bookingManager.setBookingStorageService(this.bookingStorageService);
//        //Gets&Sets BookingRequest Persistance and business for test also sets storage
//        this.bookingRequestpersistenceAPI = PersistenceImplementationProvider.getImplementation(daoFactoryBookingRequest);
//        this.bookingRequestbusinessLogicAPI = BusinessLogicImplementationProvider.getImplementation(bookingRequestpersistenceAPI);
//        this.bookingRequestStorageService = this.bookingRequestpersistenceAPI.getBookingRequestStorageService();
//        this.bookingRequestManager = this.bookingRequestbusinessLogicAPI.getBookingRequestManager();
//        this.bookingRequestManager.setBookingRequestStorageService(this.bookingRequestStorageService);
    }

    @Test
    public void BookingTestConstructor(){
        Booking test = new Booking(1,2,3, LocalDate.of(2021,9,24));
        assertThat(test.getBookingId()).isEqualTo(1);
        assertThat(test.getCustomerId()).isEqualTo(2);
        assertThat(test.getSalesOfficerId()).isEqualTo(3);
        assertThat(test.getBookingDate()).isEqualTo(LocalDate.of(2021,9,24));
        assertThat(test).isExactlyInstanceOf(Booking.class);
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

//
//    @Test void TestBookingReceive(){
//        //this.bookingManager.
//
//    }
//
//    @Test
//    public void BookingRequestHandleDeclineTest(){
//        //Create stub.
//
//        //this.bookingRequestManager.declineRequest(testRequest);
//
//    }
//
//    @Test
//    public void BookingRequestHandleAcceptTest(){
//
//    }
//
//    @Test
//    public void BookingRequestBusinessLogicTest(){
//
//    }
//
//    @Test
//    public void BookingBusinessLogicTest(){
//
//    }
}
