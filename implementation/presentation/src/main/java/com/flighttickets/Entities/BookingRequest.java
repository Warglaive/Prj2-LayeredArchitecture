package com.flighttickets.Entities;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
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
    //TODO: Maybe change to int and customer(id)
    private SystemUser customer;
    /**
     * SalesOfficer to be set by SalesOfficer entity when action is performed(Accept/Reject)
     */
    //TODO: Maybe change to int and salesOfficer(id)
    private SystemUser salesOfficer;
    private int passengersAmount;
    private boolean status;

    public BookingRequest(int id, LocalDate departureDate, LocalDate returnDate, String departureDestination, String destination, SystemUser customer, int passengersAmount, boolean status) {
        this.id = id;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.departureDestination = departureDestination;
        this.destination = destination;
        this.customer = customer;
        this.passengersAmount = passengersAmount;
        this.status = status;
    }

    @Override
    public Integer getNaturalId() {
        return this.id;
    }

    @Override
    public int getId() {
        return 0;
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
                + departureDestination + ", destination=" + destination + ", customer=" + customer.toString()
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
        return new BookingRequest((Integer) parts[0], (LocalDate) parts[1], (LocalDate) parts[2], (String) parts[3], (String) parts[4], (SystemUser) parts[5],
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
                this.customer,
                this.passengersAmount,
                this.status
        };
    }
}
