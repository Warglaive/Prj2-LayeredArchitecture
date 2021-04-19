package com.flighttickets.BusinessLogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterInputValidatorImpl implements RegisterInputValidator {
    @Override
    public boolean isNameValid(String firstName) {
        Pattern pattern = Pattern.compile("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.find();
    }

    @Override
    public boolean isEmailValid(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    /**
     * ^                                   # start of line
     * (?=.*[0-9])                       # positive lookahead, digit [0-9]
     * (?=.*[a-z])                       # positive lookahead, one lowercase character [a-z]
     * (?=.*[A-Z])                       # positive lookahead, one uppercase character [A-Z]
     * (?=.*[!@#&()–[{}]:;',?/*~$^+=<>]) # positive lookahead, one of the special character in this [..]
     * .                                 # matches anything
     * {8,20}                            # length at least 8 characters and maximum of 20 characters
     * $                                   # end of line
     *
     * @param password
     * @return
     */
    @Override
    public boolean isPasswordValid(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$\n";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    @Override
    public boolean isAddressValid(String address) {
        String regex = " [A-Za-z0-9'\\.\\-\\s\\,]";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(address);
        return matcher.find();
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
