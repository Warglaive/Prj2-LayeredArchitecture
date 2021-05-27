package com.flighttickets.Entities;

import com.flighttickets.Persistance.TicketStorageService;

import java.sql.SQLException;
import java.util.List;

public interface TicketManager {

    /**
     * Create a ticket
     *
     * @param id
     * @param price
     * @param passengerid
     * @param bookingid
     * @param flightid
     * @param status
     * @return ticket
     */
    Ticket createTicket(int id, int price, int passengerid, int bookingid, int flightid, String status);

    /**
     * Add a ticket
     *
     * @param ticket
     */
    void add(Ticket ticket) throws SQLException, ClassNotFoundException;

    /**
     * Gets all tickets
     *
     * @return List ticket
     */
    List<Ticket> getAll();

    /**
     * Edit a ticket
     */
    void edit(int id, Ticket ticket) throws SQLException, ClassNotFoundException;

    void setTicketStorageService(TicketStorageService ticketStorageService);
}
