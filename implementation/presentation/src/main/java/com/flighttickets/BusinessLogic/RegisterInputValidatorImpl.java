package com.flighttickets.BusinessLogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterInputValidatorImpl implements RegisterInputValidator {
    @Override
    public boolean isFirstNameValid(String firstName) {
        Pattern pattern = Pattern.compile("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.find();
    }

    @Override
    public boolean isLastNameValid(String lastName) {
        return false;
    }

    @Override
    public boolean isEmailValid(String email) {
        return false;
    }

    @Override
    public boolean isPasswordValid(String password) {
        return false;
    }

    @Override
    public boolean isAddressValid(String address) {
        return false;
    }
    /**
     * This will ensure that there is a non-name character or no character before the name (beginning of string),
     * that the name consists of at least 1 alphabetic character,
     * potentially followed by 1-23 of characters in the set a-z ',.- without two ' ,.- characters following each other and
     * then followed by an alphabetic character, followed by a non-name character or no character (end of string).
     * Also, use the i modifier for case-insensitivity
     *
     * @param customer
     * @return
     */

}
