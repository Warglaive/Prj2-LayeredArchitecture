package com.flighttickets.Persistance;

import com.flighttickets.Entities.Booking;
import com.flighttickets.Entities.Ticket;
import com.flighttickets.Entities.TicketMapper;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.util.List;

public class TicketStorageService {

    private final PGDAOFactory pgdaoFactory;
    private final PGDAO<Integer, Ticket> ticketDAO;
    private final String tableName = "ticket";

    public TicketStorageService(PGDAOFactory pgdaoFactory){
        this.pgdaoFactory = pgdaoFactory;
        this.pgdaoFactory.registerMapper(Ticket.class, new TicketMapper());
        this.ticketDAO = this.pgdaoFactory.createDao(Ticket.class);
    }

    public List<Ticket> getAll(){
        return this.ticketDAO.getAll();
    }

    public void insert(Ticket ticket){
        this.ticketDAO.save(ticket);
    }
    public void update(Ticket ticket){
        this.ticketDAO.update(ticket);
    }

    public List<Ticket> getOpenTickets(String destination) {
        System.out.println("Returning tickets from " + destination);
        return ticketDAO.anyQuery(
                "select ticket.* from (((ticket INNER JOIN flight ON ticket.flightid = flight.flightid)" +
                        "INNER JOIN route ON flight.routeid = route.routeid)" +
                        "INNER JOIN airport ON route.start_airport = airport.airportid)" +
                        "where ticket.status = 'ForSale' and airport.name = '"+destination+"'");

    }

    public Ticket sellTicket(int bookingId, Ticket toBeSold){
        toBeSold.setBookingid(bookingId);
        toBeSold.setStatus("Sold");
        this.ticketDAO.update(toBeSold);
        return toBeSold;
    }


}
