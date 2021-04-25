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
    private SystemUser customer;
    /**
     * SalesOfficer to be set by SalesOfficer entity when action is performed(Accept/Reject)
     */
    private SystemUser salesOfficer;


    @Override
    public Integer getNaturalId() {
        return this.id;
    }

    @Override
    public int getId() {
        return 0;
    }
}
