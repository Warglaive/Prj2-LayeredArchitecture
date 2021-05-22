package com.flighttickets.Persistance;

import com.flighttickets.Entities.Ticket;
import com.flighttickets.Entities.TicketMapper;
import com.flighttickets.PGDataSource;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

public class TicketStorageService {

    public void insert(Ticket ticket){
        // Use the provided data source
        PGDAOFactory pdaof = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        pdaof.registerMapper(Ticket.class, new TicketMapper());
        // get a dao (no transactions yet).
        PGDAO<Integer, Ticket> ticketDAO = pdaof.createDao(Ticket.class);
        ticketDAO.save(ticket);
    }
    public void update(Ticket ticket){
        PGDAOFactory pdaof = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        pdaof.registerMapper(Ticket.class, new TicketMapper());
        // get a dao (no transactions yet).
        PGDAO<Integer, Ticket> ticketDAO = pdaof.createDao(Ticket.class);
        ticketDAO.update(ticket);
    }
}
