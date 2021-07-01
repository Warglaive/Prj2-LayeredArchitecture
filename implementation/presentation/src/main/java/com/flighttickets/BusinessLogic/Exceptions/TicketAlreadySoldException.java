package com.flighttickets.BusinessLogic.Exceptions;

public class TicketAlreadySoldException extends Exception {
    public TicketAlreadySoldException() {
        super("This ticket has already been sold!");
    }
}
