package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

public class Ticket implements Entity2<Integer> {

    @ID(generated = true)
    int ticketid;

    int price;
    int passengerid;
    int bookingid;
    int flightid;
    String status; //could probably convert this to enum


    public Ticket(int ticketid, int price, int passengerid, int bookingid, int flightid, String status){
        this.ticketid = ticketid;
        this.price = price;
        this.passengerid = passengerid;
        this.bookingid = bookingid;
        this.flightid = flightid;
        this.status = status;
    }
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + this.ticketid +
                ", price='" + this.price + '\'' +
                ", passengerid='" + this.passengerid + '\'' +
                ", bookingid='" + this.bookingid + '\'' +
                ", flightid='" + this.flightid + '\'' +
                ", status='" + this.status + '\'' +
                '}';
    }

    Object[] asParts() {

        return new Object[]{
                this.ticketid,
                this.price,
                this.passengerid,
                this.bookingid,
                this.flightid,
                this.status
        };
    }

    @Override
    public Integer getNaturalId() {
        return this.ticketid;
    }

    public int getTicketid() {
        return this.ticketid;
    }
    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(int passengerid) {
        this.passengerid = passengerid;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public int getFlightid() {
        return flightid;
    }

    public void setFlightid(int flightid) {
        this.flightid = flightid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int getId() {
        return this.ticketid;
    }
}
