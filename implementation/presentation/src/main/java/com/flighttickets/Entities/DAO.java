package com.flighttickets.Entities;

import javafx.collections.ObservableList;

import java.sql.ResultSet;

public interface DAO<T> {
    T getById(long id);

    T getEntityFromResultSet(ResultSet resultSet);

    ObservableList<T> getAll();

    ObservableList<T> getAllFromResultSet(ResultSet resultSet);

    
}
