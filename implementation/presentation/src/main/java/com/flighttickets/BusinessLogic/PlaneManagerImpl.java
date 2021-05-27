package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Plane;
import com.flighttickets.Entities.PlaneManager;
import com.flighttickets.Persistance.PlaneStorageService;

import java.sql.SQLException;
import java.util.List;

public class PlaneManagerImpl implements PlaneManager {

    private PlaneStorageService planeStorageService;

    @Override
    public Plane createPlane(int id, String registration, String brand, String type, int seatsOnBoard, int extraLegroomSeats, int firstClassSeats) {
        return new Plane(id, registration, brand, type, seatsOnBoard, extraLegroomSeats, firstClassSeats);
    }

    @Override
    public void add(Plane plane) throws SQLException, ClassNotFoundException {
        this.planeStorageService.insert(plane);
    }

    @Override
    public List<Plane> getPlanes() {
        return this.planeStorageService.getPlanes();
    }

    //@Override
    public PlaneStorageService getPlaneStorageService(){
        return this.planeStorageService;
    }

    @Override
    public void setPlaneStorageService(PlaneStorageService planeStorageService) {
        this.planeStorageService = planeStorageService;
    }
}
