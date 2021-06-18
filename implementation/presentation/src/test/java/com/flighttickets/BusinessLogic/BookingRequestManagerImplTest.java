package com.flighttickets.BusinessLogic;
import com.flighttickets.BusinessLogic.Exceptions.DateOutOfBoundException;
import com.flighttickets.BusinessLogic.Exceptions.TicketAlreadySoldException;
import com.flighttickets.Entities.*;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.Mockito;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.mockito.Mockito.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingRequestManagerImplTest {

    BookingRequestManagerImpl serviceMock  = Mockito.mock(BookingRequestManagerImpl.class);

    BookingManagerImpl bookingMock = Mockito.mock(BookingManagerImpl.class);

    TicketManagerImpl ticketMock = Mockito.mock(TicketManagerImpl.class);

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
        when(serviceMock.declineRequest(base)).thenReturn(expected);
        assertThat(serviceMock.declineRequest(base).getStatus()).isEqualTo("Declined");
        verify(serviceMock).declineRequest(base);
    }

    //Testing service acceptBookingRequest
    @Test
    public void acceptBookingRequestMockTest(){
        BookingRequest expected = new BookingRequest(1,2,3,
                "Schiphol", "Fraport",
                LocalDate.of(2021,9,24), LocalDate.of(2021, 9,27),
                1, "Accepted");
        when(serviceMock.acceptRequest(base)).thenReturn(expected);
        assertThat(serviceMock.acceptRequest(base).getStatus()).isEqualTo("Accepted");
        verify(serviceMock).acceptRequest(base);
    }

    //Create a failing booking Request
    @Test
    public void createBookingRequestTestException() throws DateOutOfBoundException, SQLException, ClassNotFoundException {
        //A really bad request made by a user who tries to travel back in time
        BookingRequest badRequest = new BookingRequest(1,2,3,
                "Schiphol", "Fraport",
                LocalDate.of(2021,1,10), LocalDate.of(2021, 1,27),
                1, "Pending");

        doThrow(DateOutOfBoundException.class)
                .when(serviceMock)
                .add(badRequest);

        ThrowingCallable code = () -> {
            serviceMock.add(badRequest);
        };

        assertThatCode(code)
                .isInstanceOf(Exception.class)
                .isExactlyInstanceOf(DateOutOfBoundException.class);

        verify(serviceMock).add(badRequest);
    }

    //Create a working booking request
    @Test
    public void createBookingRequestNoExceptionTest() throws DateOutOfBoundException, SQLException, ClassNotFoundException {
        BookingRequest goodRequest = new BookingRequest(1,2,3,
                "Schiphol", "Fraport",
                LocalDate.of(2022,1,10), LocalDate.of(2022, 1,27),
                1, "Pending");

        ThrowingCallable code = () -> {
            serviceMock.add(goodRequest);
        };

        assertThatCode(code).doesNotThrowAnyException();
        verify(serviceMock).add(goodRequest);
    }

    @Test
    public void openBookingRequestListTest(){
        List<BookingRequest> test = new ArrayList();
        test.add(base);
        test.add(second);
        test.add(third);

        when(serviceMock.getPendingRequests()).thenReturn(test);
        assertThat(serviceMock.getPendingRequests()).isNotNull();
        verify(serviceMock).getPendingRequests();
    }

    @Test
    public void newBookingTest(){
        ThrowingCallable code = () -> {
            bookingMock.add(bookingBase);
        };

        assertThatCode(code).doesNotThrowAnyException();
        verify(bookingMock).add(bookingBase);
    }

    @Test
    public void soldTicketExceptionTest() throws TicketAlreadySoldException{
        Ticket soldTicket = new Ticket(2, 400, 2, 2, 1, "Sold");
        int fakeBookingId = 1;

        doThrow(TicketAlreadySoldException.class)
                .when(ticketMock)
                .sell(fakeBookingId,soldTicket);

        ThrowingCallable code = () -> {
            ticketMock.sell(fakeBookingId, soldTicket);
        };

        assertThatCode(code)
                .isInstanceOf(Exception.class)
                .isExactlyInstanceOf(TicketAlreadySoldException.class);

        verify(ticketMock).sell(fakeBookingId,soldTicket);

    }

    @Test
    public void sellTicketNoExceptionTest() throws TicketAlreadySoldException{
        Ticket soldTicket = new Ticket(2, 400, 2, 2, 1, "ForSale");
        int fakeBookingId = 1;

        ThrowingCallable code = () -> {
            ticketMock.sell(fakeBookingId, soldTicket);
        };

        assertThatCode(code)
                .doesNotThrowAnyException();

        verify(ticketMock).sell(fakeBookingId,soldTicket);

    }

    @Test
    public void newTicketTest() throws SQLException, ClassNotFoundException {
        ThrowingCallable code = () -> {
            ticketMock.add(ticketBase);
        };

        assertThatCode(code).doesNotThrowAnyException();
        verify(ticketMock).add(ticketBase);
    }
}
