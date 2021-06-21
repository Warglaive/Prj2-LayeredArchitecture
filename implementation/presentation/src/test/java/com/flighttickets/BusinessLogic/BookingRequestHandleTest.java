package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.*;
import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.BookingRequestStorageService;
import com.flighttickets.Persistance.BookingStorageService;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceImplementationProvider;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookingRequestHandleTest {
    private BookingRequestManager bookingRequestManager;
    //BookingRequestManager test = BookingRequestManagerImpl();

    private BookingRequestStorageService bookingRequestStorageService;


    private BusinessLogicAPI businesslogicAPI;
    private PersistenceAPI persistenceAPI;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        PGDAOFactory daoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        daoFactory.registerMapper(BookingRequest.class, new BookingRequestMapper());


        this.persistenceAPI = PersistenceImplementationProvider.getPersistenceImplementation(daoFactory);
        this.businesslogicAPI = BusinessLogicImplementationProvider.getImplementation(persistenceAPI);

        this.bookingRequestManager = this.businesslogicAPI.getBookingRequestManager();


        this.bookingRequestManager.setBookingRequestStorageService(this.persistenceAPI.getBookingRequestStorageService());
        this.bookingRequestStorageService = this.bookingRequestManager.getBookingRequestStorageService();
        this.bookingRequestManager.add(new BookingRequest(1,2,3,
                "Schiphol", "Fraport",
                LocalDate.of(2021,9,24), LocalDate.of(2021, 9,27),
                1, "Pending"));
        
    }

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

    @Test
    public void createBookingRequestTest(){
        BookingRequest Expected = new BookingRequest(1,2,3,
                "Schiphol", "Fraport",
                LocalDate.of(2021,9,24), LocalDate.of(2021, 9,27),
                1, "Pending");
        BookingRequest Actual = this.bookingRequestManager.createBookingRequest(1,2,3,
                "Schiphol", "Fraport",
                LocalDate.of(2021,9,24), LocalDate.of(2021, 9,27),
                1, "Pending");

        assertThat(Actual).usingRecursiveComparison().isEqualTo(Expected);
    }

    @Test
    public void ReceiveBookingRequestListTest(){
        List<BookingRequest> Actual = this.bookingRequestManager.getPendingRequests();
        List<BookingRequest> Expected = this.bookingRequestStorageService.getPendingRequests();

        assertThat(Actual).usingRecursiveComparison().isEqualTo(Expected);


    }

    @Test
    public void BookingRequestHandleDeclineTest(){

        List<BookingRequest> pendingRequests = this.bookingRequestManager.getPendingRequests();
        int pendingCount = this.bookingRequestManager.getPendingRequests().size();
        assertThat(pendingCount).isNotEqualTo(pendingRequests.size()-1);

        this.bookingRequestManager.declineRequest(pendingRequests.get(0));
        pendingCount = this.bookingRequestManager.getPendingRequests().size();

        assertThat(pendingCount).isEqualTo(pendingRequests.size()-1);
    }

    @Test
    public void BookingRequestHandleAcceptTest(){

        List<BookingRequest> pendingRequests = this.bookingRequestManager.getPendingRequests();
        int pendingCount = this.bookingRequestManager.getPendingRequests().size();
        assertThat(pendingCount).isNotEqualTo(pendingRequests.size()-1);

        this.bookingRequestManager.acceptRequest(pendingRequests.get(0));
        pendingCount = this.bookingRequestManager.getPendingRequests().size();

        assertThat(pendingCount).isEqualTo(pendingRequests.size()-1);
    }
    @Test
    public void BookingRequestGetAllByCustomerIdTest(){
        BookingRequest bookingRequest = new BookingRequest(1,2,3,
                "Schiphol", "Fraport",
                LocalDate.of(2021,9,24), LocalDate.of(2021, 9,27),
                1, "Pending");
        List<BookingRequest> requests = this.bookingRequestManager.getAllByCustomerId(2);
        assertThat(requests.get(0)).usingRecursiveComparison().ignoringFields("bookingRequestId", "status").isEqualTo(bookingRequest);
    }

}
