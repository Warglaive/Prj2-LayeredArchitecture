package com.flighttickets.BusinessLogic;
import com.flighttickets.BusinessLogic.Exceptions.DateOutOfBoundException;
import com.flighttickets.BusinessLogic.Exceptions.SystemUserStorageException;
import com.flighttickets.BusinessLogic.Exceptions.TicketAlreadySoldException;
import com.flighttickets.Entities.*;
import com.flighttickets.Persistance.*;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.security.auth.login.AccountNotFoundException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.mockito.Mockito.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingRequestTicketLoginMockTest {

    @Mock
    BookingRequestStorageService bookingRequestStorageServiceMock = Mockito.mock(BookingRequestStorageService.class);


    @Mock
    BookingStorageService bookingStorageServiceMock = Mockito.mock(BookingStorageService.class);


    @Mock
    TicketStorageService ticketStorageServiceMock = Mockito.mock(TicketStorageService.class);


    @Mock
    SystemUserStorageService systemUserStorageServiceMock = Mockito.mock(SystemUserStorageService.class);

    //LIST OF OBJECTS THAT CAN BE USED FOR TESTING
    BookingRequest base = new BookingRequest(1,2,3,
            "Schiphol", "Fraport",
            LocalDate.of(2021,9,24), LocalDate.of(2021, 9,27),
            1, "Pending");
    BookingRequest second = new BookingRequest(1,2,3,
            "Dusseldorf", "Miami",
            LocalDate.of(2021,10,16), LocalDate.of(2021, 10,20),
            1, "Pending");
    BookingRequest third = new BookingRequest(1,2,3,
            "Eindhoven", "Dublin",
            LocalDate.of(2021,9,24), LocalDate.of(2021, 12,31),
            1, "Pending");

    Booking bookingBase = new Booking(1,2,3,LocalDate.of(2022, 1,27));
    Booking bookingSecond = new Booking(1,2,3,LocalDate.of(2022, 1,27));
    Booking bookingThird = new Booking(1,2,3,LocalDate.of(2022, 1,27));

    Ticket ticketBase =  new Ticket(1, 200, 1, 1, 1, "ForSale");
    Ticket ticketSecond = new Ticket(2, 400, 2, 2, 1, "ForSale");
    Ticket ticketThird = new Ticket(3, 150, 3, 3, 1, "ForSale");


    //Testing service declineBookingRequest
    @Test
    public void declineBookingRequestMockTest(){
        BookingRequest expected = new BookingRequest(1,2,3,
                "Schiphol", "Fraport",
                LocalDate.of(2021,9,24), LocalDate.of(2021, 9,27),
                1, "Declined");
        //Doc
        when(bookingRequestStorageServiceMock.updateRequest(base)).thenReturn(expected);
        //Sut
        BookingRequestManagerImpl testManager = new BookingRequestManagerImpl();

        testManager.setBookingRequestStorageService(bookingRequestStorageServiceMock);

        assertThat(testManager.declineRequest(base).getStatus()).isEqualTo("Declined");

        verify(bookingRequestStorageServiceMock).updateRequest(base);
    }

    //Testing service acceptBookingRequest
    @Test
    public void acceptBookingRequestMockTest(){
        BookingRequest expected = new BookingRequest(1,2,3,
                "Schiphol", "Fraport",
                LocalDate.of(2021,9,24), LocalDate.of(2021, 9,27),
                1, "Accepted");

        when(bookingRequestStorageServiceMock.updateRequest(base)).thenReturn(expected);

        BookingRequestManagerImpl testManager = new BookingRequestManagerImpl();

        testManager.setBookingRequestStorageService(bookingRequestStorageServiceMock);

        assertThat(testManager.acceptRequest(base).getStatus()).isEqualTo("Accepted");

        verify(bookingRequestStorageServiceMock).updateRequest(base);
    }


    //Create a failing booking Request
    @Test
    public void createBookingRequestTestException() throws DateOutOfBoundException, SQLException, ClassNotFoundException {
        //A really bad request made by a user who tries to travel back in time
        BookingRequest badRequest = new BookingRequest(1,2,3,
                "Schiphol", "Fraport",
                LocalDate.of(2021,1,10), LocalDate.of(2021, 1,27),
                1, "Pending");

        BookingRequestManagerImpl testManager = new BookingRequestManagerImpl();
        testManager.setBookingRequestStorageService(bookingRequestStorageServiceMock);
        //Datum is al verstreken

        ThrowingCallable code = () -> {
            testManager.add(badRequest);
        };

        assertThatCode(code)
                .isInstanceOf(Exception.class)
                .isExactlyInstanceOf(DateOutOfBoundException.class);
    }

    //Create a working booking request
    @Test
    public void createBookingRequestNoExceptionTest() {
        BookingRequest goodRequest = new BookingRequest(1,2,3,
                "Schiphol", "Fraport",
                LocalDate.of(2022,1,10), LocalDate.of(2022, 1,27),
                1, "Pending");

        when(bookingRequestStorageServiceMock.insert(goodRequest)).thenReturn(goodRequest);

        BookingRequestManagerImpl testManager = new BookingRequestManagerImpl();
        testManager.setBookingRequestStorageService(bookingRequestStorageServiceMock);

        ThrowingCallable code = () -> {
            testManager.add(goodRequest);
        };

        assertThatCode(code).doesNotThrowAnyException();
        verify(bookingRequestStorageServiceMock).insert(goodRequest);
    }

    @Test
    public void openBookingRequestListTest(){
        List<BookingRequest> test = new ArrayList();
        test.add(base);
        test.add(second);
        test.add(third);

        when(bookingRequestStorageServiceMock.getPendingRequests()).thenReturn(test);

        BookingRequestManagerImpl testManager = new BookingRequestManagerImpl();
        testManager.setBookingRequestStorageService(bookingRequestStorageServiceMock);

        assertThat(testManager.getPendingRequests()).isNotNull();

        verify(bookingRequestStorageServiceMock).getPendingRequests();
    }

    @Test
    public void openBookingRequestByIdListTest(){
        List<BookingRequest> test = new ArrayList();
        test.add(base);
        test.add(second);
        test.add(third);

        when(bookingRequestStorageServiceMock.getAllByCustomerId(1)).thenReturn(test);

        BookingRequestManagerImpl testManager = new BookingRequestManagerImpl();
        testManager.setBookingRequestStorageService(bookingRequestStorageServiceMock);

        assertThat(testManager.getAllByCustomerId(1)).isNotNull();

        verify(bookingRequestStorageServiceMock).getAllByCustomerId(1);
    }

    @Test
    public void newBookingTest(){
        when(bookingStorageServiceMock.insert(bookingBase)).thenReturn(1);
        BookingManagerImpl testManager = new BookingManagerImpl();
        testManager.setBookingStorageService(bookingStorageServiceMock);

        ThrowingCallable code = () -> {
            testManager.add(bookingBase);
        };

        assertThatCode(code).doesNotThrowAnyException();
        verify(bookingStorageServiceMock).insert(bookingBase);
    }

    @Test
    public void soldTicketExceptionTest() throws TicketAlreadySoldException{
        Ticket soldTicket = new Ticket(2, 400, 2, 2, 1, "Sold");
        int fakeBookingId = 1;

        TicketManagerImpl testManager = new TicketManagerImpl();

        ThrowingCallable code = () -> {
            testManager.sell(fakeBookingId, soldTicket);
        };

        assertThatCode(code)
                .isInstanceOf(Exception.class)
                .isExactlyInstanceOf(TicketAlreadySoldException.class);

    }

    @Test
    public void sellTicketNoExceptionTest() throws TicketAlreadySoldException{
        Ticket notSoldTicket = new Ticket(2, 400, 2, 2, 1, "ForSale");
        int fakeBookingId = 1;

        when(ticketStorageServiceMock.sellTicket(fakeBookingId, notSoldTicket)).thenReturn(notSoldTicket);

        TicketManagerImpl testManager = new TicketManagerImpl();
        testManager.setTicketStorageService(ticketStorageServiceMock);

        ThrowingCallable code = () -> {
            testManager.sell(fakeBookingId, notSoldTicket);
        };

        assertThatCode(code)
                .doesNotThrowAnyException();

        verify(ticketStorageServiceMock).sellTicket(fakeBookingId,notSoldTicket);
    }

    @Test
    public void LoginTestNoExceptionTest() throws AccountNotFoundException, SystemUserStorageException{
        SystemUser testUser = new SystemUser(1,"Jasper", "Lamers", "Jasper-l@live.nl", "Southpark1!", "Lindeboom 79 Mook", "Customer");
        when(systemUserStorageServiceMock.retrieve("Jasper-l@live.nl", "Southpark1")).thenReturn(testUser);

        SystemUserManagerImpl testManager = new SystemUserManagerImpl();
        testManager.setSystemUserStorageService(systemUserStorageServiceMock);
        ThrowingCallable code = () -> {
            testManager.login("Jasper-l@live.nl", "Southpark1");
        };

        assertThatCode(code)
                .doesNotThrowAnyException();

        verify(systemUserStorageServiceMock).retrieve("Jasper-l@live.nl", "Southpark1");
    }

    @Test
    public void LoginTestRoleGetting() throws AccountNotFoundException, SystemUserStorageException{
        SystemUser testUser = new SystemUser(1,"Jasper", "Lamers", "Jasper-l@live.nl", "Southpark1!", "Lindeboom 79 Mook", "SalesOfficer");
        when(systemUserStorageServiceMock.retrieve("Jasper-l@live.nl", "Southpark1")).thenReturn(testUser);

        SystemUserManagerImpl testManager = new SystemUserManagerImpl();
        testManager.setSystemUserStorageService(systemUserStorageServiceMock);
        ThrowingCallable code = () -> {
            testManager.login("Jasper-l@live.nl", "Southpark1");
        };

        assertThatCode(code)
                .doesNotThrowAnyException();

        verify(systemUserStorageServiceMock).retrieve("Jasper-l@live.nl", "Southpark1");

        assertThat(systemUserStorageServiceMock.retrieve("Jasper-l@live.nl", "Southpark1").getRole()).isEqualTo("SalesOfficer");
    }

    @Test
    public void LoginTestAccountNotFoundExceptionTest() throws AccountNotFoundException, SystemUserStorageException{
        SystemUser testUser = new SystemUser(1,"Jasper", "Lamers", "Jasper-l@live.nl", "Southpark1!", "Lindeboom 79 Mook", "Customer");
        doThrow(AccountNotFoundException.class)
                .when(systemUserStorageServiceMock)
                .retrieve("JasperFake@live.nl", "NotSouthpark1");

        SystemUserManagerImpl testManager = new SystemUserManagerImpl();
        testManager.setSystemUserStorageService(systemUserStorageServiceMock);

        ThrowingCallable code = () -> {
            testManager.login("JasperFake@live.nl", "NotSouthpark1");
        };

        assertThatCode(code)
                .isInstanceOf(Exception.class)
                .isExactlyInstanceOf(AccountNotFoundException.class);

        verify(systemUserStorageServiceMock).retrieve("JasperFake@live.nl", "NotSouthpark1");
    }

    @Test
    public void LoginTestMultipleAccountsExceptionTest() throws AccountNotFoundException, SystemUserStorageException{
        SystemUser testUser = new SystemUser(1,"Jasper", "Lamers", "Jasper-l@live.nl", "Southpark1!", "Lindeboom 79 Mook", "Customer");
        doThrow(SystemUserStorageException.class)
                .when(systemUserStorageServiceMock)
                .retrieve("JasperFake@live.nl", "NotSouthpark1");

        SystemUserManagerImpl testManager = new SystemUserManagerImpl();
        testManager.setSystemUserStorageService(systemUserStorageServiceMock);

        ThrowingCallable code = () -> {
            testManager.login("JasperFake@live.nl", "NotSouthpark1");
        };

        assertThatCode(code)
                .isInstanceOf(Exception.class)
                .isExactlyInstanceOf(SystemUserStorageException.class);

        verify(systemUserStorageServiceMock).retrieve("JasperFake@live.nl", "NotSouthpark1");
    }

}
