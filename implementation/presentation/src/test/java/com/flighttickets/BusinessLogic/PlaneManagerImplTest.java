package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.*;
import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.FlightStorageService;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceImplementationProvider;
import com.flighttickets.Persistance.PlaneStorageService;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlaneManagerImplTest {
    private PlaneManager planeManager;

    private PlaneStorageService planeStorageService;


    private BusinessLogicAPI businesslogicAPI;
    private PersistenceAPI persistenceAPI;


    @BeforeEach
    void setUp(){
        PGDAOFactory daoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        daoFactory.registerMapper(Plane.class, new PlaneMapper());


        this.persistenceAPI = PersistenceImplementationProvider.getPersistenceImplementation(daoFactory);
        this.businesslogicAPI = BusinessLogicImplementationProvider.getImplementation(persistenceAPI);

        this.planeManager = this.businesslogicAPI.getPlaneManager();


        this.planeManager.setPlaneStorageService(this.persistenceAPI.getPlaneStorageService());
        this.planeStorageService = this.planeManager.getPlaneStorageService();
    }

    @Test
    void createPlaneTest(){
        Plane actual = this.planeManager.createPlane(1, "11-aa-bb", "Boeing", "Small passenger plane", 120, 50, 10);
        Plane expected = new Plane(1, "11-aa-bb", "Boeing", "Small passenger plane", 120, 50, 10);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
    @Test
    void addPlaneTest() throws SQLException, ClassNotFoundException {
        Plane toAdd = this.planeManager.createPlane(1, "11-aa-bb", "Boeing", "Small passenger plane", 120, 50, 10);
        this.planeManager.add(toAdd);
        List<Plane> planes = this.planeStorageService.getAll();
        Plane last = planes.get(planes.size()-1);

        assertThat(last).usingRecursiveComparison().ignoringFields("planeid").isEqualTo(toAdd);
    }
    @Test
    void getPlanesTest(){
        List<Plane> allPlanes = this.planeManager.getPlanes();
        List<Plane> expected = this.planeStorageService.getAll();

        assertThat(allPlanes).usingRecursiveComparison().isEqualTo(expected);

    }
}
