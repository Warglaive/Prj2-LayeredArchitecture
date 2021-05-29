package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

import java.time.LocalDate;

public class Flight implements Entity2<Integer> {

    @ID(generated = true)
    int id;

    LocalDate flightdate;
    int routeid;
    int planeid;


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

        this.flightdate = date;

        this.routeid = routeId;
        this.planeid = planeId;

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
        return "Flight{" + "flight_id=" + id + ", flight_date=" + flightdate.toString() + ", route_id=" + routeid +", plane_id="+ planeid+'}';
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
                this.flightdate,
                this.routeid,
                this.planeid
        };
    }

    /**
     * Getters and setters for each field
     */
    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFlight_date() {
        return flightdate;
    }

    public void setFlight_date(LocalDate date) {
        this.flightdate = date;
    }

    public int getRoute_id() {
        return routeid;
    }

    public void setRoute_id(int routeId) {
        this.routeid = routeId;
    }

    public int getPlane_id() {
        return planeid;
    }

    public void setPlane_id(int planeId) {
        this.planeid = planeId;
    }
}
