package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.*;
import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.AirportStorageService;
import com.flighttickets.Persistance.FlightStorageService;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceImplementationProvider;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FlightManagerImplTest {
    private FlightManager flightManager;

    private FlightStorageService flightStorageService;


    private BusinessLogicAPI businesslogicAPI;
    private PersistenceAPI persistenceAPI;


    @BeforeEach
    void setUp(){
        PGDAOFactory daoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        daoFactory.registerMapper(Flight.class, new FlightMapper());


        this.persistenceAPI = PersistenceImplementationProvider.getPersistenceImplementation(daoFactory);
        this.businesslogicAPI = BusinessLogicImplementationProvider.getImplementation(persistenceAPI);

        this.flightManager = this.businesslogicAPI.getFlightManager();


        this.flightManager.setFlightStorageService(this.persistenceAPI.getFlightStorageService());
        this.flightStorageService = this.flightManager.getFlightStorageService();
    }

    @Test
    void createFlightTest(){
        Flight Actual = this.flightManager.createFlight(1, LocalDate.of(2021, 10, 10), 1, 1);
        Flight Expected = new Flight(1, LocalDate.of(2021, 10, 10), 1, 1);

        assertThat(Actual).usingRecursiveComparison().isEqualTo(Expected);
    }
    @Test
    void addFlightTest(){
        Flight toAdd = this.flightManager.createFlight(1, LocalDate.of(2021, 10, 10), 1, 1);
        this.flightManager.add(toAdd);
        List<Flight> allFlights = this.flightStorageService.getAll();
        Flight added = allFlights.get(allFlights.size()-1);
        assertThat(added).usingRecursiveComparison().ignoringFields("flightid").isEqualTo(toAdd);
    }
    @Test
    void getFlightByIdTest(){
        Flight toAdd = this.flightManager.createFlight(1, LocalDate.of(2021, 10, 10), 1, 1);
        this.flightManager.add(toAdd);
        List<Flight> allFlights = this.flightStorageService.getAll();
        Flight added = allFlights.get(allFlights.size()-1);

        Flight actual = this.flightManager.getFlightById(added.getId());

        assertThat(actual).usingRecursiveComparison().isEqualTo(added);
    }
}
