package com.flighttickets.Entities;

import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class CustomerDAO implements DAO<Customer> {
    @Override
    public Customer getById(long id) {
        return null;
    }

    @Override
    public Customer getEntityFromResultSet(ResultSet resultSet) {
        return null;
    }

    @Override
    public ObservableList<Customer> getAll() {
        return null;
    }

    @Override
    public ObservableList<Customer> getAllFromResultSet(ResultSet resultSet) {
        return null;
    }

    @Override
    public void updateEmail(String email, long id) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void insert(Customer entity) {

    }
}
