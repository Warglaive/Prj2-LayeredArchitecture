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

    public List<Ticket> getOpenTickets(String departure, String destination) {
        System.out.println("Displaying tickets from " + departure + " to " +destination);
        return ticketDAO.anyQuery(
                "select ticket.* from ((((ticket INNER JOIN flight ON ticket.flightid = flight.flightid)" +
                        "INNER JOIN route ON flight.routeid = route.routeid)" +
                        "INNER JOIN airport as airportStart ON route.start_airport = airportStart.airportid)" +
                        "INNER JOIN airport as airportEnd ON route.end_airport = airportEnd.airportid)" +
                        "where ticket.status = 'ForSale' and airportStart.name = '"+departure+"' and airportEnd.name = '"+destination+"'");
    }

    public Ticket sellTicket(int bookingId, Ticket toBeSold){
        toBeSold.setBookingid(bookingId);
        toBeSold.setStatus("Sold");
        this.ticketDAO.update(toBeSold);
        return toBeSold;
    }


}
