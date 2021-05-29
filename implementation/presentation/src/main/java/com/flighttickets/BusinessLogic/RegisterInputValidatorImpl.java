package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.RegisterInputValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterInputValidatorImpl implements RegisterInputValidator {
    /**
     * This will ensure that there is a non-name character or no character before the name (beginning of string),
     * that the name consists of at least 1 alphabetic character,
     * potentially followed by 1-23 of characters in the set a-z ',.- without two ' ,.- characters following each other and
     * then followed by an alphabetic character, followed by a non-name character or no character (end of string).
     * Also, use the i modifier for case-insensitivity
     *
     * @param name
     * @return
     */

    @Override
    public boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    @Override
    public boolean isEmailValid(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    /**
     * Be between 8 and 40 characters long
     * Contain at least one digit.
     * Contain at least one lower case character.
     * Contain at least one upper case character.
     * Contain at least on special character from [ @ # $ % ! . ].
     *
     * @param password
     * @return
     */
    @Override
    public boolean isPasswordValid(String password) {
        String regex = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    /**
     * must have space between strings(any strings)
     * valid example: franciscannenstraat 10 - VALID
     * invalid example: franciscanenstraat10 -INVALID
     *
     * @param address
     * @return
     */
    @Override
    public boolean isAddressValid(String address) {
        String regex = " [A-Za-z0-9'\\.\\-\\s\\,]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        return matcher.find();
    }
}
