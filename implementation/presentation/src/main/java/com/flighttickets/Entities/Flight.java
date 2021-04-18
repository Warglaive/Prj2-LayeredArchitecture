package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

import java.time.LocalDate;

public class Flight implements Entity2<Integer> {

    @ID(generated = true)
    int id;

    LocalDate flight_date;
    int route_id;
    int plane_id;


    /**
     * create customer object
     *
     * @param id
     * @param date
     * @param routeId
     * @param planeId
     */
    public Flight(int id, LocalDate date, int routeId, int planeId) {
        this.id = id;

        this.flight_date = date;

        this.route_id = routeId;
        this.plane_id = planeId;

    }

    /**
     * needed for the Mapper
     * @return
     */
    @Override
    public Integer getNaturalId() {
        return this.id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    /**
     * needed for the Mapper
     * @return
     */
    @Override
    public String toString() {
        return "Flight{" + "flight_id=" + id + ", flight_date=" + flight_date.toString() + ", route_id=" + route_id +", plane_id="+ plane_id+'}';
    }

    /**
     * needed for the Mapper
     * @param parts
     * @return
     */
    static Flight fromParts(Object[] parts) {
        return new Flight((Integer) parts[0], (LocalDate)parts[1],(Integer) parts[2], (Integer) parts[3]);
    }

    /**
     * needed for the Mapper
     * @return
     */
    Object[] asParts() {

        return new Object[]{
                this.id,
                this.flight_date,
                this.route_id,
                this.plane_id
        };
    }

    /**
     * Getters and setters for each field
     */
    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFlight_date() {
        return flight_date;
    }

    public void setFlight_date(LocalDate date) {
        this.flight_date = date;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int routeId) {
        this.route_id = routeId;
    }

    public int getPlane_id() {
        return plane_id;
    }

    public void setPlane_id(int planeId) {
        this.plane_id = planeId;
    }
}
