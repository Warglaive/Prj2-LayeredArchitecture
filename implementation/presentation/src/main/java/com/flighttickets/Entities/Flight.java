package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

import java.time.LocalDate;

public class Flight implements Entity2<Integer> {

    @ID
    int flightid;

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
        this.flightid = id;
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
        return this.flightid;
    }

    @Override
    public int getId() {
        return this.flightid;
    }

    public int getFlightid(){
        return this.flightid;
    }

    /**
     * needed for the Mapper
     * @return
     */
    @Override
    public String toString() {
        return "Flight{" + "flightid=" + flightid + ", flight_date=" + flightdate.toString() + ", route_id=" + routeid +", plane_id="+ planeid+'}';
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
                this.flightid,
                this.flightdate,
                this.routeid,
                this.planeid
        };
    }

    /**
     * Getters and setters for each field
     */
    public void setId(int id) {
        this.flightid = id;
    }

    public LocalDate getFlightdate() {
        return flightdate;
    }

    public void setFlightdate(LocalDate date) {
        this.flightdate = date;
    }

    public int getRouteid() {
        return routeid;
    }

    public void setRouteid(int routeId) {
        this.routeid = routeId;
    }

    public int getPlaneid() {
        return planeid;
    }

    public void setPlaneid(int planeId) {
        this.planeid = planeId;
    }
}
