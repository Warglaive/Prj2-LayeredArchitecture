package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Customer;

public class RegisterInputValidatorImpl implements RegisterInputValidator{
    @Override
    public boolean isFirstNameValid(Customer customer) {
        return false;
    }

    @Override
    public boolean isLastNameValid(Customer customer) {
        return false;
    }

    @Override
    public boolean isEmailValid(Customer customer) {
        return false;
    }

    @Override
    public boolean isPasswordNameValid(Customer customer) {
        return false;
    }

    @Override
    public boolean isAddressNameValid(Customer customer) {
        return false;
    }
}
