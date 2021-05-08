package com.flighttickets.Entities;

import com.flighttickets.Persistance.PlaneStorageService;

import java.sql.SQLException;
import java.util.List;

public interface PlaneManager {
    /**
     * @param registration
     * @param brand
     * @param type
     * @param seatsOnBoard
     * @param extraLegroomSeats
     * @param firstClassSeats
     * @return Plane
     */

    Route createRoute(int id, String registration, String brand, String type, int seatsOnBoard, int extraLegroomSeats, int firstClassSeats);

    /**
     * @param plane
     * @return Plane
     */
    void add(Plane plane) throws SQLException, ClassNotFoundException;

    /**
     * @param planeId
     * @return Plane
     */
    List<Route> getByPlaneId(int planeId);

    void setPlaneStorageService(PlaneStorageService planeStorageService);
}
