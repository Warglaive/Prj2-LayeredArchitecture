package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;

public interface RegisterInputValidator {
    boolean isFirstNameValid(Customer customer);

    boolean isLastNameValid(Customer customer);

    boolean isEmailValid(Customer customer);

    boolean isPasswordNameValid(Customer customer);

    boolean isAddressNameValid(Customer customer);

}
