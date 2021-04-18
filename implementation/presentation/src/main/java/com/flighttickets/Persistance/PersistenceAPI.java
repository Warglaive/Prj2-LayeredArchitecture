package com.flighttickets.Persistance;

/**
 * Facade that provides all persistence/storage services to the business logic.
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */

public interface PersistenceAPI {

    CustomerStorageService getCustomerStorageService();

    FlightStorageService getFlightStorageService();
    // This interface can be extended with all services that need to be made
    // available to the business logic, e.g. to store Products:
    //
    // ProductStorageService getProductStorageService( ProductManager productManager );
}
