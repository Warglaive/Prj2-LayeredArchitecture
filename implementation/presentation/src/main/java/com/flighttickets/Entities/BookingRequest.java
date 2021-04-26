package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

import java.time.LocalDate;

public class BookingRequest implements Entity2<Integer> {
    @ID
    int id;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private String departureDestination;
    private String destination;
    /**
     * Only SystemUser with role == "Customer" can access this class.
     */
    private int customerId;
    /**
     * SalesOfficer to be set by SalesOfficer entity when action is performed(Accept/Reject)
     */
    private int salesOfficer;
    private int passengersAmount;
    private boolean status;

    public BookingRequest(int id, LocalDate departureDate, LocalDate returnDate, String departureDestination, String destination, int customerId, int passengersAmount, boolean status) {
        this.id = id;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.departureDestination = departureDestination;
        this.destination = destination;
        this.customerId = customerId;
        this.passengersAmount = passengersAmount;
        this.status = status;
    }

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
     *
     * @return
     */
    //TODO: Check customer.ToString() - may cause issues
    @Override
    public String toString() {
        return "BookingRequest{" + "id=" + id + ", departureDate=" + departureDate + ", returnDate=" + returnDate + ", departureDestination="
                + departureDestination + ", destination=" + destination + ", customer=" + customerId
                + ", passengersAmount=" + passengersAmount
                + ", status=" + status + '}';
    }

    /**
     * needed for the Mapper
     *
     * @param parts
     * @return
     */
    static BookingRequest fromParts(Object[] parts) {
        return new BookingRequest((Integer) parts[0], (LocalDate) parts[1], (LocalDate) parts[2], (String) parts[3], (String) parts[4], (Integer) parts[5],
                (Integer) parts[6], (boolean) parts[7]);
    }

    /**
     * needed for the Mapper
     *
     * @return
     */
    Object[] asParts() {

        return new Object[]{
                this.id,
                this.departureDate,
                this.returnDate,
                this.departureDestination,
                this.destination,
                this.customerId,
                this.passengersAmount,
                this.status
        };
    }

    public int getSalesOfficer() {
        return salesOfficer;
    }

    public void setSalesOfficer(int salesOfficer) {
        this.salesOfficer = salesOfficer;
    }
}
