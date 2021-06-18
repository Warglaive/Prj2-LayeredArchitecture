package com.flighttickets.BusinessLogic;

import com.flighttickets.Persistance.BookingRequestStorageService;
import com.flighttickets.Persistance.BookingStorageService;
import com.flighttickets.Persistance.TicketStorageService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class BookingRequestPersistenceTest {

    @Mock
    BookingRequestStorageService bookingRequestStorageMock = Mockito.mock(BookingRequestStorageService.class);

    @Mock
    BookingStorageService bookingStorageMock = Mockito.mock(BookingStorageService.class);

    @Mock
    TicketStorageService ticketStorageMock = Mockito.mock(TicketStorageService.class);

    @Test
    public void BookingRequestPersistenceMock(){

    }

    @Test
    public void BookingPersistenceMock(){

    }

    @Test
    public void TicketPersistenceMock(){

    }


}
