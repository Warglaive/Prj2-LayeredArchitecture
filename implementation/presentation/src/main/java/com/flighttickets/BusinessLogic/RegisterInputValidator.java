package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;

public interface RegisterInputValidator {

    boolean isNameValid(String name);

    boolean isEmailValid(String email);

    boolean isPasswordValid(String password);

    boolean isAddressValid(String address);

}
