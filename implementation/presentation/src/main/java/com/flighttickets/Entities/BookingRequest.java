package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

import java.time.LocalDate;

public class BookingRequest implements Entity2<Integer> {
    @ID
    int requestId;

    /**
     * Only SystemUser with role == "Customer" can access this class.
     */
    private int customerId;
    /**
     * SalesOfficer to be set by SalesOfficer entity when action is performed(Accept/Reject)
     */
    private int salesOfficerId;
    private String departureDestination;
    private String arrivalDestination;

    private LocalDate departureDate;
    private LocalDate returnDate;


    private int passengersAmount;
    private String status;

    public BookingRequest(int requestId, int customerId, int salesOfficerId, String departureDestination, String arrivalDestination, LocalDate departureDate, LocalDate returnDate, int passengersAmount, String status) {
        this.requestId = requestId;
        this.customerId = customerId;
        //salesOfficerId to be assigned by salesOfficer on Bookings review
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.departureDestination = departureDestination;
        this.arrivalDestination = arrivalDestination;
        this.passengersAmount = passengersAmount;
        this.status = status;
    }

    @Override
    public Integer getNaturalId() {
        return this.requestId;
    }

    @Override
    public int getId() {
        return this.requestId;
    }

    /**
     * needed for the Mapper
     *
     * @return
     */
    //TODO: Check customer.ToString() - may cause issues
    @Override
    public String toString() {
        return "BookingRequest{" + "id=" + requestId + ", departureDate=" + departureDate + ", returnDate=" + returnDate + ", departureDestination="
                + departureDestination + ", destination=" + arrivalDestination + ", customer=" + customerId
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
        return new BookingRequest((Integer) parts[0], (Integer) parts[1], (Integer) parts[2], (String) parts[3], (String) parts[4], (LocalDate) parts[5],
                (LocalDate) parts[6], (Integer) parts[7], (String) parts[8]);
    }

    /**
     * needed for the Mapper
     *
     * @return
     */
    Object[] asParts() {

        return new Object[]{
                this.requestId,
                this.departureDate,
                this.returnDate,
                this.departureDestination,
                this.arrivalDestination,
                this.customerId,
                this.passengersAmount,
                this.status
        };
    }

    public int getSalesOfficerId() {
        return salesOfficerId;
    }

    public void setSalesOfficerId(int salesOfficerId) {
        this.salesOfficerId = salesOfficerId;
    }
}
