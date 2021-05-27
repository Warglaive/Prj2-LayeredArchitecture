package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.Ticket;
import com.flighttickets.Entities.TicketManager;
import com.flighttickets.Persistance.TicketStorageService;

import java.sql.SQLException;
import java.util.List;

public class TicketManagerImpl implements TicketManager {

    private TicketStorageService ticketStorageService;
    private Ticket selectedTicket;


    @Override
    public Ticket createTicket(int id, int price, int passengerid, int bookingid, int flightid, String status) {
        return new Ticket(id,price,passengerid,bookingid,flightid,status);
    }

    @Override
    public void add(Ticket ticket) throws SQLException, ClassNotFoundException {
        this.ticketStorageService.insert(ticket);
    }

    @Override
    public List<Ticket> getAll() {
        return this.ticketStorageService.getAll();
    }


    @Override
    public void edit(int id, Ticket ticket) throws SQLException, ClassNotFoundException {
        ticket.setTicketid(id);
        this.ticketStorageService.update(ticket);
    }

    @Override
    public void setTicketStorageService(TicketStorageService ticketStorageService) {
        this.ticketStorageService = ticketStorageService;
    }


}
