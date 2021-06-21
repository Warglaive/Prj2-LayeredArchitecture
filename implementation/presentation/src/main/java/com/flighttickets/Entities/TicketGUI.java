package com.flighttickets.Entities;

import java.time.LocalDate;

public class TicketGUI {

    private int id;
    private String ticketStatus;
    private int ticketPassenger;
    private LocalDate ticketBooking;
    private String ticketRouteStart;
    private String ticketRouteEnd;
    private double ticketPrice;


    public TicketGUI(int id, String ticketStatus, int ticketPassenger, LocalDate ticketBooking, String ticketRouteStart, String ticketRouteEnd, double ticketPrice) {
        this.id = id;
        this.ticketStatus = ticketStatus;
        this.ticketPassenger = ticketPassenger;
        this.ticketBooking = ticketBooking;
        this.ticketRouteStart = ticketRouteStart;
        this.ticketRouteEnd = ticketRouteEnd;
        this.ticketPrice = ticketPrice;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketPassenger() {
        return ticketPassenger;
    }

    public void setTicketPassenger(int ticketPassenger) {
        this.ticketPassenger = ticketPassenger;
    }

    public LocalDate getTicketBooking() {
        return ticketBooking;
    }

    public void setTicketBooking(LocalDate ticketBooking) {
        this.ticketBooking = ticketBooking;
    }

    public String getTicketRouteStart() {
        return ticketRouteStart;
    }

    public void setTicketRouteStart(String ticketRouteStart) {
        this.ticketRouteStart = ticketRouteStart;
    }

    public String getTicketRouteEnd() {
        return ticketRouteEnd;
    }

    public void setTicketRouteEnd(String ticketRouteEnd) {
        this.ticketRouteEnd = ticketRouteEnd;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
