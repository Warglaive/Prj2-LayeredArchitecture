package com.flighttickets.Entities;

import com.flighttickets.Persistance.SystemUserStorageService;

public interface BookingRequestManager {
    BookingRequest createBookingRequest() ;

    void setBookingRequestStorageService(SystemUserStorageService systemUserStorageService);
}
