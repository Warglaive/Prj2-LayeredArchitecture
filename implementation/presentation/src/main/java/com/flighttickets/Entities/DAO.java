package com.flighttickets.Entities;

import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DAO<T> {
    /**
     * @param id
     * @return resultSet of objects with corresponding ID received from DB
     */
    T getById(long id);

    /**
     * @param resultSet - received from DB
     * @return make resultSet to actual object to work with
     */
    T getEntityFromResultSet(ResultSet resultSet);

    /**
     * @return resultSet of objects
     */
    ObservableList<T> getAll();


    /**
     * @param resultSet - received from DB
     * @return ObservableList of Objects
     */
    ObservableList<T> getAllFromResultSet(ResultSet resultSet);

    /**
     * @param email - new email
     * @param id    of object(can be Customer/SalesOfficer etc.)
     */
    void updateEmail(String email, long id);

    /**
     * delete entity with Id
     * @param id
     */
    void deleteById(long id);

    /**
     * Insert entity into the DB
     * @param entity
     */
    void insert(T entity) throws SQLException, ClassNotFoundException;
}
