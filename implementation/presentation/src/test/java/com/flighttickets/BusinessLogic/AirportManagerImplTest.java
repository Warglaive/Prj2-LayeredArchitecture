package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.*;
import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.AirportStorageService;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceImplementationProvider;
import com.flighttickets.Persistance.TicketStorageService;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AirportManagerImplTest {
    private AirportManager airportManager;

    private AirportStorageService airportportStorageService;


    private BusinessLogicAPI businesslogicAPI;
    private PersistenceAPI persistenceAPI;


    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        PGDAOFactory daoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        daoFactory.registerMapper(Airport.class, new AirportMapper());


        this.persistenceAPI = PersistenceImplementationProvider.getPersistenceImplementation(daoFactory);
        this.businesslogicAPI = BusinessLogicImplementationProvider.getImplementation(persistenceAPI);

        this.airportManager = this.businesslogicAPI.getAirportManager();


        this.airportManager.setAirportStorageService(this.persistenceAPI.getAirportStorageService());
        this.airportportStorageService = this.airportManager.getAirportStorageService();
    }
    @Test
    void createAirportTest(){
        Airport actual = this.airportManager.createAirport(1, "Schiphol", "Netherlands", "Amsterdam");
        Airport expected = new Airport(1, "Schiphol", "Netherlands", "Amsterdam");
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
    @Test
    void addTest() throws SQLException, ClassNotFoundException {
        Airport toadd = this.airportManager.createAirport(1, "Schiphol", "Netherlands", "Amsterdam");
        this.airportManager.add(toadd);
        List<Airport> all = this.airportportStorageService.getAll();
        Airport added = all.get(all.size()-1);
        assertThat(added).usingRecursiveComparison().ignoringFields("airportid").isEqualTo(added);
    }
    @Test
    void getAirportsTest(){
        List<Airport> Actual = this.airportManager.getAirports();
        List<Airport> Expected = this.airportportStorageService.getAll();

        assertThat(Actual).usingRecursiveComparison().isEqualTo(Expected);
    }
    @Test
    void getAirportTest() throws SQLException, ClassNotFoundException {
        Airport toadd = this.airportManager.createAirport(1, "Schiphol", "Netherlands", "Amsterdam");
        this.airportManager.add(toadd);
        List<Airport> all = this.airportportStorageService.getAll();
        Airport added = all.get(all.size()-1);

        Airport fromManager = this.airportManager.getAirport(added.getId());

        assertThat(added).usingRecursiveComparison().isEqualTo(fromManager);
    }

}
