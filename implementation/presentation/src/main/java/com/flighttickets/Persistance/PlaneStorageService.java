package com.flighttickets.Persistance;


import com.flighttickets.Entities.Plane;
import com.flighttickets.Entities.PlaneMapper;
import com.flighttickets.PGDataSource;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.util.List;

public class PlaneStorageService {

        private final PGDAO<Integer, Plane> planeDAO;
        private final String tableName = "plane";


        public PlaneStorageService(PGDAOFactory daoFactory) {
            // Use the provided data source
            PGDAOFactory pdaof = new PGDAOFactory(PGDataSource.DATA_SOURCE);

            // Register mappers for the classes in this app
            pdaof.registerMapper(Plane.class, new PlaneMapper());
            // get a dao (no transactions yet).
            this.planeDAO = pdaof.createDao(Plane.class);
        }

    /**
     * Save of Plane
     *
     * @param Plane
     */
    public void insert(Plane Plane) {
        this.planeDAO.save(Plane);
    }

    public List<Plane> getAll() {
        return this.planeDAO.getAll();
    }
}

