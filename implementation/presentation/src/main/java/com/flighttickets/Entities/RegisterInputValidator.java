package com.flighttickets.Entities;

public interface RegisterInputValidator {

    boolean isNameValid(String name);

    boolean isEmailValid(String email);

    boolean isPasswordValid(String password);

    boolean isAddressValid(String address);

}
