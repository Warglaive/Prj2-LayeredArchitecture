package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

import java.time.LocalDate;

public class BookingRequest implements Entity2<Integer> {
    @ID
    int bookingRequestId;

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

    public BookingRequest(int BookingRequestId, int customerId, int salesOfficerId, String departureDestination, String arrivalDestination, LocalDate departureDate, LocalDate returnDate, int passengersAmount, String status) {
        this.bookingRequestId = BookingRequestId;
        this.customerId = customerId;
        this.salesOfficerId = salesOfficerId;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.departureDestination = departureDestination;
        this.arrivalDestination = arrivalDestination;
        this.passengersAmount = passengersAmount;
        this.status = status;
    }

    @Override
    public Integer getNaturalId() {
        return this.bookingRequestId;
    }

    @Override
    public int getId() {
        return this.bookingRequestId;
    }

    /**
     * needed for the Mapper
     *
     * @return
     */
    //TODO: Check customer.ToString() - may cause issues
    @Override
    public String toString() {
        return "BookingRequest{" + "requestId=" + bookingRequestId + ", departureDate=" + departureDate + ", returnDate=" + returnDate + ", departureDestination="
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
                this.bookingRequestId,
                this.customerId,
                this.salesOfficerId,
                this.departureDestination,
                this.arrivalDestination,
                this.departureDate,
                this.returnDate,
                this.passengersAmount,
                this.status
        };
    }

    public int getBookingRequestId() {
        return bookingRequestId;
    }

    public void setBookingRequestId(int bookingRequestId) {
        this.bookingRequestId = bookingRequestId;
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

    public String getDepartureDestination() {
        return departureDestination;
    }

    public void setDepartureDestination(String departureDestination) {
        this.departureDestination = departureDestination;
    }

    public String getArrivalDestination() {
        return arrivalDestination;
    }

    public void setArrivalDestination(String arrivalDestination) {
        this.arrivalDestination = arrivalDestination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getPassengersAmount() {
        return passengersAmount;
    }

    public void setPassengersAmount(int passengersAmount) {
        this.passengersAmount = passengersAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
