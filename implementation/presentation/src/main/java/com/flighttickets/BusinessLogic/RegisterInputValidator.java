package com.flighttickets.BusinessLogic;

public interface RegisterInputValidator {

    boolean isNameValid(String name);

    boolean isEmailValid(String email);

    boolean isPasswordValid(String password);

    boolean isAddressValid(String address);

}
