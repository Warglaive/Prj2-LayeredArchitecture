package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

public class Plane implements Entity2<Integer> {


    @ID(generated = true)
    int id;
    /**
     * Fields to be used to encrypt pass, validate names etc.
     */
    private String registration;
    private String brand;
    private String type;
    private int seats_on_board;
    private int extra_legroom_seats;
    private int first_class_seats;

    /**
     * create customer object
     *
     * @param id
     * @param registration
     * @param brand
     * @param type
     * @param seatsOnBoard
     * @param extraLegroomSeats
     * @param firstClassSeats

     */

    public Plane(int id, String registration, String brand, String type, int seatsOnBoard, int extraLegroomSeats, int firstClassSeats){
        this.id = id;
        this.registration = registration;
        this.brand = brand;
        this.type = type;
        this.seats_on_board = seatsOnBoard;
        this.extra_legroom_seats = extraLegroomSeats;
        this.first_class_seats = firstClassSeats;
    }

    @Override
    public String toString() {
        return "plane id = " + this.id + ", registration: " + this.registration + ", brand: " + this.brand + ", type: " + this.type + ", seats on board: " + this.seats_on_board +
                ", extra legroom seats: " + this.extra_legroom_seats + ", first class seats: " + this.first_class_seats;
    }

    /**
     * needed for the Mapper
     * @return
     */
    Object[] asParts() {

        return new Object[]{
                this.id,
                this.registration,
                this.brand,
                this.type,
                this.seats_on_board,
                this.extra_legroom_seats,
                this.first_class_seats
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

}
