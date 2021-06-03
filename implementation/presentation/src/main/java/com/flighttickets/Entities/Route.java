package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

public class Route implements Entity2<Integer> {

    @ID
    int id;
    /**
     * Fields to be used to encrypt pass, validate names etc.
     */
    private int start_airport;
    private int end_airport;
    private int plannerId;

    /**
     * create route object
     *
     * @param id
     * @param startAirport
     * @param endAirport
     * @param plannerId

     */

    public Route(int id, int startAirport, int endAirport, int plannerId){
        this.id = id;
        this.start_airport = startAirport;
        this.end_airport = endAirport;
        this.plannerId = plannerId;
    }

    @Override
    public String toString() {
        return "route id: " + this.id + ", start airport id: " + this.start_airport + ", end airport: " + this.end_airport
                + " by planner id: " + this.plannerId;
    }

    /**
     * needed for the Mapper
     * @return
     */
    Object[] asParts() {

        return new Object[]{
                this.id,
                this.start_airport,
                this.end_airport,
                this.plannerId
        };
    }

    @Override
    public Integer getNaturalId() {
        return this.id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart_airport() {
        return start_airport;
    }

    public void setStart_airport(int start_airport) {
        this.start_airport = start_airport;
    }

    public int getEnd_airport() {
        return end_airport;
    }

    public void setEnd_airport(int end_airport) {
        this.end_airport = end_airport;
    }

    public int getPlannerId() {
        return plannerId;
    }

    public void setPlannerId(int plannerId) {
        this.plannerId = plannerId;
    }
}
