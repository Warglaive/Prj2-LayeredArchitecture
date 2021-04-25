package com.flighttickets.Entities;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

public class BookingRequest implements Entity2<Integer> {
    @ID
    private Integer id;

    BookingRequest(){

    }
    @Override
    public Integer getNaturalId() {
        return this.id;
    }

    @Override
    public int getId() {
        return 0;
    }
}
