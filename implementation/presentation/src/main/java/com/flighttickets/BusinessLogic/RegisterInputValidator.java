package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;

public interface RegisterInputValidator {
    boolean isFirstNameValid(String firstName);

    boolean isLastNameValid(String lastName);

    boolean isEmailValid(String email);

    boolean isPasswordValid(String password);

    boolean isAddressValid(String address);

}
