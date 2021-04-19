package com.flighttickets.BusinessLogic.Exceptions;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException(String msg) {
        super(msg);
    }
}
