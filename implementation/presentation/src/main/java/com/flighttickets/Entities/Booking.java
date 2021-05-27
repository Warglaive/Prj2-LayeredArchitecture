package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

import java.time.LocalDate;

public class Booking implements Entity2<Integer> {

    @ID
    int bookingId;

    private int customerId;

    private int salesOfficerId;

    private LocalDate bookingDate;

    public Booking(int bookingId, int customerId, int salesOfficerId, LocalDate bookingDate){
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.salesOfficerId = salesOfficerId;
        this.bookingDate = bookingDate;
    }

    @Override
    public Integer getNaturalId() {
        return this.bookingId;
    }

    @Override
    public int getId() {
        return this.bookingId;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingId=" + bookingId + ", customerId= " + customerId + ", salesOfficerId=" + salesOfficerId +
                ", bookingDate= " + bookingDate + "}";
    }

    static Booking fromParts(Object[] parts){
        return new Booking((Integer) parts[0], (Integer) parts[1], (Integer) parts[2], (LocalDate) parts[3]);
    }

    Object[] asParts(){
        return new Object[]{
                this.bookingId,
                this.salesOfficerId,
                this.customerId,
                this.bookingDate
        };
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSalesOfficerId() {
        return salesOfficerId;
    }

    public void setSalesOfficerId(int salesOfficerId) {
        this.salesOfficerId = salesOfficerId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
}
