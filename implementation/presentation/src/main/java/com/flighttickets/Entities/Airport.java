package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.Entity2;
import nl.fontys.sebivenlo.dao.ID;

public class Airport implements Entity2<Integer> {

    @ID(generated = true)
    int id;
    /**
     * Fields to be used to encrypt pass, validate names etc.
     */
    private String name;
    private String country;
    private String city;

    /**
     * create airport object
     *
     * @param id
     * @param name
     * @param country
     * @param city
     */

    public Airport(int id, String name, String country, String city){
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", name: " + name +
                ", country: " + country  +
                ", city: " + city;
    }

    /**
     * needed for the Mapper
     * @return
     */
    Object[] asParts() {

        return new Object[]{
                this.id,
                this.name,
                this.country,
                this.city
        };
    }

    @Override
    public Integer getNaturalId() {return this.id;}

    @Override
    public int getId() {return this.id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
