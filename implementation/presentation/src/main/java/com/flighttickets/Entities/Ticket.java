package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

public class Ticket implements Entity2<Integer> {

    @ID(generated = true)
    int id;

    int price; //price will be in cent, for example €23.45 would be 2345
    int passengerid;
    int bookingid;
    int flightid;
    String status; //could probably convert this to enum


    public Ticket(int id, int price, int passengerid, int bookingid, int flightid, String status){
        this.id = id;
        this.price = price;
        this.passengerid = passengerid;
        this.bookingid = bookingid;
        this.flightid = flightid;
        this.status = status;
    }
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + this.id +
                ", price='" + this.price + '\'' +
                ", passengerid='" + this.passengerid + '\'' +
                ", bookingid='" + this.bookingid + '\'' +
                ", flightid='" + this.flightid + '\'' +
                ", status='" + this.status + '\'' +
                '}';
    }

    Object[] asParts() {

        return new Object[]{
                this.id,
                this.price,
                this.passengerid,
                this.bookingid,
                this.flightid,
                this.status
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
